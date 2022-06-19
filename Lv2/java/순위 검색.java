import java.util.*;

class Solution {
    static String[] temp;
    static int max_cnt;
    static String[] subset;
    static Map<String, ArrayList<Integer>> map;

    static void powerset(String[] strs, int idx, boolean[] sel, int point) {
        if(idx == strs.length) {
            StringBuilder builder = new StringBuilder();

            for(int i=0; i<sel.length; i++) {
                if(sel[i]) builder.append(strs[i]);
            }

            if(map.get(builder.toString()) != null){
                var value = map.get(builder.toString());
                value.add(point);
            }
            else {
                map.put(builder.toString(), new ArrayList<Integer>(){{
                    add(point);
                }});
            }
            return;
        }

        sel[idx]=true;
        powerset(strs, idx+1, sel, point);
        sel[idx]=false;
        powerset(strs, idx+1, sel, point);
    }


    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (String s : info) {
            temp = s.split(" ");
            powerset(Arrays.copyOfRange(temp,0, 4), 0, new boolean[temp.length], Integer.parseInt(temp[4]));
        }

        for(ArrayList<Integer> list : map.values()){
            list.sort(Comparator.naturalOrder());
        }
        
        
        for (int cIndex = 0; cIndex < query.length; cIndex++) {
            int[] indexs = {0, 2, 4, 6};
            String[] temp = query[cIndex].split(" ");
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < 4; i++) {
                if (!temp[indexs[i]].equals("-")) builder.append(temp[indexs[i]]);
            }

            ArrayList<Integer> value = map.get(builder.toString());
            int point = Integer.parseInt(temp[7]);
            

            if (value != null) {
                int low = 0, high = value.size()-1;
                int index = 0;
                while(low <= high){
                    index = (low+high) / 2;
                    if(value.get(index) < point) low = index + 1;
                    else high = index - 1;
                }

                answer[cIndex] = value.size() - low;
            }
        }
        return answer;
    }
}
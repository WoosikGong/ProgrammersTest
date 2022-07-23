import java.util.*;

class Solution {


    static Map<String, Sale> map = new HashMap<>();

    static int[] answer;

    static class Sale{
        int index;
        List<Integer> amounts = new ArrayList<>();

        public Sale(int index){
            this.index = index;
        }
    }
    
    public static int[] dfs(List<Integer>[] list, String[] enroll, int depth){
        int amount = 0;
        List<Integer> price = new ArrayList<>();
        if(list[depth].size() == 0){
            if(map.get(enroll[depth-1]).amounts.size() == 0) return null;
            List<Integer> temp = new ArrayList<>();

            for(int a : map.get(enroll[depth-1]).amounts){
                answer[depth-1] += (a-(a/10));
                temp.add(a/10);
            }
            return temp.stream().mapToInt(o -> o).toArray();
        }
        else{
            for(int i=0;i<list[depth].size();i++){
                int[] temp = dfs(list, enroll, list[depth].get(i));
                if(temp != null){
                    for(int a : temp) {
                        amount += (a - (a/10));
                        price.add(a/10);
                    }
                }
            }
            if(depth - 1 >= 0){
                for(int a : map.get(enroll[depth-1]).amounts){
                    answer[depth-1] += (a-(a/10));
                    amount += (a-(a/10));
                    price.add(a/10);
                }
            }
        }

        if(depth - 1 >= 0) answer[depth-1] = amount;
        return price.stream().mapToInt(o -> o).toArray();
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        List<Integer>[] list = new ArrayList[enroll.length + 1];

        map.put("-", new Sale(0));
        for(int i=0;i < enroll.length; i++){
            map.put(enroll[i], new Sale(i+1));
        }
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();

        for(int i = 0;i<referral.length;i++) {
            list[map.get(referral[i]).index].add(map.get(enroll[i]).index);
        }

        for(int i = 0;i<seller.length;i++) map.get(seller[i]).amounts.add(amount[i]*100);

        dfs(list, enroll, 0);

        return answer;
    }
}
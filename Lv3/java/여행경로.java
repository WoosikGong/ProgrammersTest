import java.util.*;

class Solution {

    static int N = 0;
    static Stack<Integer> stack = new Stack<>();
    static List<Integer> ans = new ArrayList<>();
    static List<String> temp;

    static boolean visited[];
    static int[][] route;

    static void dfs(int depth){
        stack.push(depth);
        if(stack.size() == N + 1){
            for(int i=0;i<stack.size();i++){
                if(ans.get(i) == 10001 || temp.get(ans.get(i)).compareTo(temp.get(stack.get(i))) > 0) {
                    Collections.copy(ans, stack);
                    break;
                }
                else if(temp.get(ans.get(i)).compareTo(temp.get(stack.get(i))) < 0) break;
            }
        }
        else{
            for(int i=0;i<route.length;i++){
                if(!visited[i] && route[i][0] == depth){
                    visited[i] = true;
                    dfs(route[i][1]);
                    stack.pop();
                    visited[i] = false;
                }
            }
        }
    }


    public String[] solution(String[][] tickets) {
        ans = new ArrayList<>();
        N = tickets.length;
        visited = new boolean[N];
        route = new int[tickets.length][2];
        String[] answer = new String[tickets.length + 1];
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i=0;i<tickets.length;i++){
            if(!tickets[i][0].equals("ICN")) set.add(tickets[i][0]);
            if(!tickets[i][1].equals("ICN")) set.add(tickets[i][1]);
        }
        temp = new ArrayList<>(set);
        Collections.sort(temp);
        temp.add(0, "ICN");

        for(int i=0;i<temp.size();i++) map.put(temp.get(i), i);

        for(int i=0;i<tickets.length;i++) {
            route[i][0] = map.get(tickets[i][0]);
            route[i][1] = map.get(tickets[i][1]);
            ans.add(10001);
        }
        ans.add(10001);

        dfs(0);

        for(int i=0;i<ans.size();i++){
            answer[i] = temp.get(ans.get(i));
        }

        return answer;
    }

}
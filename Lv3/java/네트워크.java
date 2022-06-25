import java.util.*;

class Solution {
    
    static Queue<Integer> queue = new LinkedList<>();
    static List<Integer>[] list;
    static boolean[] check;
    static int answer = 0;

    static void bfs(int depth){
        if(!check[depth]){
            queue.offer(depth);
            check[depth] = true;

            while(!queue.isEmpty()) {
                int current = queue.peek();
                queue.poll();

                for (int i = 0; i < list[current].size(); i++) {
                    if (!check[list[current].get(i)]) {
                        queue.offer(list[current].get(i));
                        check[list[current].get(i)] = true;
                    }
                }
            }
            answer++;
        }
    }

    public static int solution(int n, int[][] computers) {
        list = new ArrayList[n];
        check = new boolean[n];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && computers[i][j] == 1) {
                    list[i].add(j);
                }
            }
        }

        for(int i=0;i<n;i++) dfs(i);

        return answer;
    }
}
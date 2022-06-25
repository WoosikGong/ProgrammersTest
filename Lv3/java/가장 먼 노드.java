import java.util.*;

class Solution {

    static Queue<Integer> queue = new LinkedList<>();
    static List<Integer>[] list;
    static int distance[];
    static boolean[] check;

    static int max = 0;

    static void bfs(int depth){
        queue.offer(depth);
        check[depth] = true;

        while(!queue.isEmpty()){
            int current = queue.peek();
            queue.poll();

            for(int i = 0;i<list[current].size();i++){
                if(!check[list[current].get(i)]){
                    distance[list[current].get(i)] = distance[current] + 1;
                    queue.offer(list[current].get(i));
                    check[list[current].get(i)] = true;
                    max = Math.max(max, distance[list[current].get(i)]);
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        list = new ArrayList[n+1];
        check = new boolean[n+1];
        distance = new int[n+1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();

        for(int i=0;i<edge.length;i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }

        dfs(1);

        for(int i : distance)
            if(i == max) answer++;

        return answer;
    }
}
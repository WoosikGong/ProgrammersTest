import java.util.*;

class Solution {

    static int N = 0;
    static int min = 0;

    static boolean[] visit;
    static List<Integer>[] list;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] distance;

    static void bfs(int depth){
        queue.offer(depth);
        visit[depth] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int i = 0;i<list[current].size();i++){
                if(!visit[list[current].get(i)]){
                    distance[list[current].get(i)] = distance[current] + 1;
                    queue.offer(list[current].get(i));
                    visit[list[current].get(i)] = true;
                }
            }
        }


    }

    static boolean check_node(String word1, String word2){
        char[] wordChr1 = word1.toCharArray();
        char[] wordChr2 = word2.toCharArray();
        int cnt = 0;

        for(int i=0;i<wordChr1.length;i++){
            if(wordChr1[i] == wordChr2[i]) cnt++;
        }

        if(cnt == word1.length()-1) return true;

        return false;
    }


    public int solution(String begin, String target, String[] words) {
        boolean check = false;

        list = new ArrayList[words.length + 1];
        visit = new boolean[words.length + 1];
        distance = new int[words.length + 1];

        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)) {
                check = true;
            }
        }
        if(!check) return 0;

        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();

        for(int i=0;i<words.length;i++) if(words[i].equals(target)) N = i+1;

        // begin
        for(int i=0;i<words.length;i++){
            if(check_node(begin, words[i])){
                list[0].add(i+1);
                list[i+1].add(0);
            }
        }

        for(int i=1;i<list.length; i++){
            for(int j=i+1; j<list.length;j++){
                if(check_node(words[i-1], words[j-1])){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }

        bfs(0);

        return distance[N];
    }
}
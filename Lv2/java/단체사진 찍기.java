import java.util.*;

class Solution {

    static Map<Character, Integer> map = new HashMap<>();
    static int N = 8;
    static boolean[] visited = new boolean[N];

    static int[] arr = new int[N];

    static String[] checkData;

    static int answer = 0;

    public static void dfs(int depth){
        if(N == depth){
            if(check()) answer++;
        }
        else{
            for(int i=0;i<N;i++){
                if(!visited[i]) {
                    visited[i] = true;
                    arr[depth] = i;
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static boolean check(){
        for (String s : checkData) {
            int ch1 = map.get(s.charAt(0));
            int ch2 = map.get(s.charAt(2));
            int val = Integer.parseInt(s.substring(4));
            char match = s.charAt(3);

            if(match == '='){
                if(Math.abs(arr[ch1]-arr[ch2]) - 1 != val) return false;
            }
            else if(match == '<'){
                if(Math.abs(arr[ch1]-arr[ch2]) - 1  >= val) return false;
            }
            else if(match == '>'){
                if(Math.abs(arr[ch1]-arr[ch2]) - 1 <= val) return false;
            }
        }
        return true;
    }

    public static int solution(int n, String[] data) {        
        answer = 0;
        char[] kakao = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        checkData = data;

        for(int i=0;i< kakao.length;i++) map.put(kakao[i], i);

        dfs(0);
        return answer;
    }
}
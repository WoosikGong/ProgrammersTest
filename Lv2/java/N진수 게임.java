import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(sb.length() <= t*m){
            sb.append(Integer.toString(num++,n).toUpperCase());
        }

        for(int i=0;i<t;i++){
            answer += sb.charAt(m*i+p-1);
        }

        return answer;
    }
}
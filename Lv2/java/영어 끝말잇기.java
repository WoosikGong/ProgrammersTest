import java.util.*;

class Solution {
   public int[] solution(int n, String[] words) {
       int[] answer = new int[2];
       Map<String, Integer> map = new HashMap<>();
       int cnt = 0;

       map.put(words[0], 1);

       for(int i=1;i<words.length;i++){
           if(words[i-1].charAt(words[i-1].length() - 1) == words[i].charAt(0)
                   && map.get(words[i]) == null) {
               map.put(words[i], i % n + 1);
           }
           else{
               cnt = i;
               break;
           }
       }

       System.out.println(cnt);

       if(cnt == 0) return answer;
       else {
               answer[0] = (cnt % n) + 1;
               answer[1] = cnt / n + 1;
       }

       return answer;
   }
}
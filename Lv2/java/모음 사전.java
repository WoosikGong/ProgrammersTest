import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;

        int[] values = {781, 156, 31, 6, 1};
        char[] letters = {'A', 'E', 'I', 'O', 'U'};
        char[] chars = word.toCharArray();

        Map<Character, Integer> map = new HashMap<>();


        for(int i=0;i<letters.length;i++) map.put(letters[i], i);

        for(int i=0;i<chars.length;i++){
            answer += (map.get(chars[i]) * values[i] + 1);
        }

        System.out.println(answer);

        return answer;
    }
}
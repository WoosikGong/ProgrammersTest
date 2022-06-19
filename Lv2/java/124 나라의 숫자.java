import java.util.*;

class Solution {

    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder("");
        List<Character> result = new ArrayList<>();

        while (n > 2) {
            if (n % 3 == 0) {
                result.add('4');
                n = (n / 3) - 1;
            } else {
                result.add(Character.forDigit(n % 3, 10));
                n /= 3;
            }
        }

        if(n<3 && n > 0) sb.append(Character.forDigit(n, 10));

        for(int i=result.size()-1;i>=0;i--){
            sb.append(result.get(i));
        }

        return sb.toString();
    }
}
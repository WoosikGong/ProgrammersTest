import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        LinkedList<Character> id = new LinkedList<>();

        new_id = new_id.toLowerCase(); // Lv.1

        sb.append(new_id.replaceAll("[~!@#$%^&*()=+\\[{\\]}}:?,<>/]", ""));

        int dot = 0;
        for (int i = 0;i<sb.length();i++) {
            if(sb.charAt(i) != '.'){
                id.add(sb.charAt(i));
                dot=0;
            }
            else if(sb.charAt(i) == '.' && dot == 0){
                dot++;
                id.add(sb.charAt(i));
            }
        }

        sb.setLength(0);
        for(char c : id) sb.append(c); // Lv3


        if(sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0); // Lv4
        if(sb.length() > 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1); // Lv4

        if(sb.length() == 0) sb.append('a'); // lv5

        if(sb.length() >= 16) {
            sb.setLength(15);
            if(sb.charAt(14) == '.') sb.deleteCharAt(14);
        }

        while(sb.length() <= 2){
            sb = sb.append(sb.charAt(sb.length()-1));
        }

        return sb.toString();
    }
}
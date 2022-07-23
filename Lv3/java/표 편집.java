import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(String command : cmd){
            String[] sp = command.split(" ");
            if(sp[0].equals("U")) k -= Integer.parseInt(sp[1]);
            else if(sp[0].equals("D")) k += Integer.parseInt(sp[1]);
            else if(sp[0].equals("C")){
                n--;
                stack.push(k);
                if(k >= n) k--;
            }
            else if(sp[0].equals("Z")){
                n++;
                if(k >= stack.pop()) k++;
            }
        }

        for(int i=0;i<n;i++) answer.append('O');
        while(!stack.isEmpty()) answer.insert((int)stack.pop(), 'X');

        return answer.toString();
    }

}
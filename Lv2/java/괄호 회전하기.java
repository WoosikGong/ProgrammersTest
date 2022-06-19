import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> st = new Stack<>();
        boolean check = true;


        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                char ch = s.charAt(j);
                if(ch == '[' || ch == '{' || ch == '(') st.push(ch);
                else if(ch == ']' || ch == '}' || ch == ')')
                {
                    char pch = '\0';
                    if(st.empty()) {
                        check = false;
                        break;
                    }
                    else{
                        pch = st.pop();
                        if((pch == '[' && ch != ']') || (pch == '{' && ch != '}') || (pch == '(' && ch != ')')){
                            check = false;
                            break;
                        }
                    }
                }
            }

            if(check && st.empty()) answer++;
            check = true;
            st.clear();

            s = s.substring(1, s.length()) + s.substring(0, 1);
        }
        return answer;
    }
}
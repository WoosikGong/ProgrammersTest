class Solution {
    public int solution(String s){
        int answer = 1000;
        StringBuilder sb = new StringBuilder();
        
        if(s.length() == 1) return 1;

        for(int i=1;i<=s.length()-1;i++){
            int cnt = 1;
            String first = s.substring(0, i);
            for(int j=0;j<s.length();j+=i){
                String last = null;
                if(j+i <= s.length() && j+i*2 <= s.length()) last = s.substring(j+i, j+i*2);
                else if(j+i < s.length() && j+i*2 > s.length()) last = s.substring(j+i);
                
                if(first.equals(last)){
                    cnt++;
                }
                else{
                    if(cnt > 1) sb.append(cnt);
                    sb.append(first);
                    cnt = 1;
                }
                first = last;
            }
            if(sb.length() < answer) answer = sb.length();
            sb.setLength(0);
        }

        return answer;
    }
}
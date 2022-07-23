class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        
        int i = 0;
        if(s >= n){
            answer = new int[n];
            while(s > 0){
                if(s / (s/n) >= 2) {
                    answer[i++] = (s/n);
                    s -= (s/n--);
                }
                else {
                    answer[i++] = s;
                    break;
                }
            }
        }
        else {
            answer = new int[]{-1};
        }
        
        return answer;
    }
}
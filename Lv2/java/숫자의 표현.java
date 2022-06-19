class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;

        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                cnt += j;
                if(cnt == n) answer++;
                else if(cnt > n) break;
            }
            cnt = 0;
        }

        return answer;
    }
}
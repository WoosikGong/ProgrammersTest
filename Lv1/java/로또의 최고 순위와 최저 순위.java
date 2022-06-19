class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int wins[] = {6, 6, 5, 4, 3, 2, 1};
        int tmp = 0, cnt = 0;
        
        for(int check : lottos)
        {
            for(int win : win_nums)
            {
                if(check == 0){
                    tmp++;
                    break;
                }
                else if(check == win) cnt++;
            }
        }
        answer[0] = wins[tmp+cnt];
        answer[1] = wins[cnt];
        return answer;
    }
}
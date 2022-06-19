import java.util.*;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<>();
        int index = 0, cnt = 0;

        for(int i=0;i<100;i++){
            for(int j=0;j<progresses.length;j++){
                if(progresses[j] < 100) progresses[j] += speeds[j];
                if(progresses[j] >= 100 && index == j){
                    cnt++;
                    index++;
                }
            }
            if(cnt > 0) {
                ans.add(cnt);
                cnt = 0;
            }
        }

        int i=0;
        answer = new int[ans.size()];
        for(int val : ans){
            answer[i++] = val;
        }

        return answer;
    }

}
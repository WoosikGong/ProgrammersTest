import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        int[][] mArrs = new int[len][2];

        if(len <= 3) return Arrays.stream(money).max().getAsInt();

        for(int i=0;i<2;i++){
            mArrs[i][0] = money[i];
            mArrs[i+1][1] = money[i+1];
        }
        mArrs[2][0] = money[2] + money[0];
        mArrs[3][1] = money[3] + money[1];

        for(int i=3;i<len-1;i++){
            mArrs[i][0] = Math.max(mArrs[i-2][0] + money[i], mArrs[i-3][0] + money[i]);
            mArrs[i][1] = Math.max(mArrs[i-2][1] + money[i], mArrs[i-3][1] + money[i]);
        }
        mArrs[len-1][1] = Math.max(mArrs[len-3][1] + money[len-1], mArrs[len-4][1] + money[len-1]);

        for(int[] arr : mArrs) answer = Math.max(answer, Math.max(arr[0], arr[1]));

        return answer;
    }
}
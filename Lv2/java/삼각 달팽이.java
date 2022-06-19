import java.util.*;

class Solution {
    public static int[] solution(int n) {
        int[] answer = {};
        int[][] ans = new int[n][n];
        List<Integer> list = new ArrayList<>();

        int num = 1;

        for(int i=0;i<n/2 + 1;i++){
            for(int j=i*2;j<n-i;j++){
                if(ans[j][i] == 0) ans[j][i] = num++;
                else break;
            }
            for(int j=i+1;j<n-i;j++){
                if(ans[n-i-1][j] == 0) ans[n-i-1][j] = num++;
                else break;
            }
            int x = n-i-1, y=n-i*2-1;
            while(x>i+1 && y > i+1){
                if(ans[x-1][y-1] == 0)ans[--x][--y] = num++;
                else break;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                list.add(ans[i][j]);
            }
        }

        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
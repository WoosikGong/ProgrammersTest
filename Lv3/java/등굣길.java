class Solution {

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        long[][] arr = new long[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = -1;
            }
        }

        for(int i=0;i<puddles.length;i++){
            if(puddles[i].length > 0) arr[puddles[i][1] - 1][puddles[i][0] - 1] = 0;
        }

        for(int i=1;i<n;i++) {
            if(arr[i-1][0] != 0 && arr[i][0] != 0) arr[i][0] = 1;
            else arr[i][0] = 0;
        }
        for(int i=1;i<m;i++) {
            if(arr[0][i-1] != 0 && arr[0][i] != 0) arr[0][i] = 1;
            else arr[0][i] = 0;
        }


        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j] != 0) arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % 1000000007;
            }
        }


        return (int)(arr[n-1][m-1]);
    }
}
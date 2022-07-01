class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arrs = new int[n][n];
        int[] res = new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arrs[i][j] = 100000;
            }
        }

        for(int i=0;i<results.length;i++) arrs[results[i][0]-1][results[i][1]-1] = 1;


        for(int mid = 0;mid<n;mid++){
            for(int start = 0;start<n;start++){
                for(int end = 0;end<n;end++){
                    if(arrs[start][end] > arrs[start][mid] + arrs[mid][end]){
                        arrs[start][end] = 1;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arrs[i][j] < 100000){
                    res[i] += 1;
                    res[j] += 1;
                }
            }
        }

        for(int i : res) if(i == n-1) answer++;

        return answer;
    }

}
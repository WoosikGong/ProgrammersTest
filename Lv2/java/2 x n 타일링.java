class Solution {
    public static long solution(int n) {
        long result[][] = {{1,1}, {1,0}};
        long x[][] = {{1,1}, {1,0}};
        long x1=0, x2=0, x3=0, x4=0;

        for(int i=0;i<n/2;i++){
            x1 = result[0][0] * result[0][0] + result[0][1] * result[1][0];
            x2 = result[0][0] * result[0][1] + result[0][1] * result[1][1];
            x3 = result[1][0] * result[0][0] + result[1][1] * result[1][0];
            x4 = result[1][0] * result[0][1] + result[1][1] * result[1][1];

            result[0][0] = x1 % 1000000007;
            result[0][1] = x2 % 1000000007;
            result[1][0] = x3 % 1000000007;
            result[1][1] = x4 % 1000000007;

        }

        if(n%2 == 1) {
            x1 = result[0][0] * x[0][0] + result[0][1] * x[1][0];
            x2 = result[0][0] * x[0][1] + result[0][1] * x[1][1];
            x3 = result[1][0] * x[0][0] + result[1][1] * x[1][0];
            x4 = result[1][0] * x[0][1] + result[1][1] * x[1][1];

            result[0][0] = x1 % 1000000007;
            result[0][1] = x2 % 1000000007;
            result[1][0] = x3 % 1000000007;
            result[1][1] = x4 % 1000000007;
        }

        return result[0][0];
    }
}
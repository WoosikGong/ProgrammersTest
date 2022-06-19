class Solution {

    static int N = 0;
    static int M = 3;

    static int[] ans = new int[M];
    static int[] arr;

    static int answer = 0;

    public static boolean isPrime(int num){
        if(num == 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0) return false;
        }

        return true;
    }


    public static void dfs(int depth, int temp){
        if (depth == M) {
            int value = 0;

            for (int a : ans) value += a;
            if(isPrime(value)) answer++;

        } else {
            for (int i = temp; i < N; i++) {
                ans[depth] = arr[i];
                dfs(depth + 1, i + 1);
            }
        }
    }

    public int solution(int[] nums) {
        arr = nums;
        N = nums.length;
        answer = 0;

        dfs(0, 0);


        return answer;
    }
}
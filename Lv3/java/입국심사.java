import java.util.*;

class Solution {

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long front = 1;
        long end = (long) times[times.length - 1] * n;

        while (front <= end) {
            long sum = 0;
            long mid = (front + end) / 2;

            for (int i = 0; i < times.length; i++) sum += (mid / times[i]);

            if (sum < n) {
                front = mid + 1;
            }
            else {
                end = mid - 1;
                answer = mid;
            }            
        }
        return answer;
    }
}
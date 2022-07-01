import java.util.*;

class Solution {
  
    public int solution(int[][] jobs) {
        int answer = 0;
        int index = 0, time = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        while(!queue.isEmpty() || index < jobs.length){
            while(index < jobs.length && jobs[index][0] <= time) {
                queue.offer(jobs[index++]);
            }

            if(queue.isEmpty()){
                queue.offer(jobs[index]);
                time = jobs[index++][0];
            }
            else{
                int t[] = queue.poll();
                answer += time-t[0]+ t[1];
                time += t[1];
            }
        }
        return answer/ jobs.length;
    }


}
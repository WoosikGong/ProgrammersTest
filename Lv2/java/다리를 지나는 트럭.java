import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0, index = 0, all_weight = 0, cnt = 0;
        Queue<Integer[]> bridge = new LinkedList<>();

        while(cnt < truck_weights.length){

            // 다리에서 내리는 놈
            if(bridge.size() > 0 && Math.abs(bridge.peek()[1] - time) == bridge_length) {
                all_weight -= bridge.poll()[0];
                cnt++;
            }

            // 다리에 올라타는 놈
            if(index < truck_weights.length && all_weight + truck_weights[index] <= weight) {
                bridge.add(new Integer[]{truck_weights[index], time});
                all_weight += truck_weights[index++];
            }
            time++;
        }

        return time;
    }

}
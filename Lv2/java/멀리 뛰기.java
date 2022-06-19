import java.util.*;

class Solution {
    public long solution(int n) {
        long answer = 0;
        List<Long> list = new ArrayList<>();
        list.add((long)1);
        list.add((long)2);
        list.add((long)3);

        for(int i=3;i<n;i++){
            list.add((list.get(i-1) + list.get(i-2)) % 1234567);
        }


        return list.get(n-1);
    }
}
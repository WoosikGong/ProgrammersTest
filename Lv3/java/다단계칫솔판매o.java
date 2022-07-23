import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();

        for(int i=0;i<enroll.length;i++){
            index.put(enroll[i], i);
            parent.put(enroll[i], referral[i]);
        }

        for(int i=0;i<seller.length;i++){
            String sell = seller[i];
            int parentSell = amount[i] * 100;
            while(parent.get(sell) != null){
                if(parentSell == 0) break;
                answer[index.get(sell)] += (parentSell- parentSell/10);
                parentSell = (parentSell/10);
                sell = parent.get(sell);
            }
        }

        return answer;
    }
}
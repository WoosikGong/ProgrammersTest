import java.util.*;

class Solution {
    public static int getNum(int N, int index){
        int result = 0;

        for(int i=0;i<=index;i++){
            result += (N * Math.pow(10, i));
        }

        return result;
    }
    
    public int solution(int N, int number) {
        int answer = -1;
        List<Set<Integer>> list = new ArrayList<>();

        for(int i=0;i<8;i++){
            Set<Integer> set = new HashSet<>();
            set.add(getNum(N, i));
            list.add(set);
        }
        
        if(number == N) return 1;

        for(int i=1;i<8;i++){
            Set<Integer> set = list.get(i);
            for(int j=1;j<=i;j++) {
                Set<Integer> pre = list.get(i-j);
                Set<Integer> post = list.get(j-1);

                for(int preNum : pre){
                    for(int postNum : post){
                        set.add(preNum + postNum);
                        set.add(preNum * postNum);
                        if(preNum - postNum > 0) set.add(preNum - postNum);
                        if(preNum > 0 && postNum > 0) set.add(preNum / postNum);
                    }
                }
            }
            if(set.contains(number)) return i+1;
        }
        return answer;
    }
}
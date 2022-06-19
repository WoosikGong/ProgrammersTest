import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] keypad = {{1,3}, {0,0}, {1, 0}, {2,0}, {0,1}, {1,1}, {2,1}, {0,2}, {1,2}, {2,2}, {0,3}, {2,3}};
        int left[] = {0, 3}, right[] = {2, 3};


        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                left[0] = keypad[numbers[i]][0];
                left[1] = keypad[numbers[i]][1];
                answer += "L";
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                right[0] = keypad[numbers[i]][0];
                right[1] = keypad[numbers[i]][1];
                answer += "R";
            }
            else{
                if(Math.abs(keypad[numbers[i]][0]-left[0]) + Math.abs(keypad[numbers[i]][1]-left[1]) >
                        Math.abs(keypad[numbers[i]][0]-right[0]) + Math.abs(keypad[numbers[i]][1]-right[1])){
                    right[0] = keypad[numbers[i]][0];
                    right[1] = keypad[numbers[i]][1];
                    answer += "R";
                }
                else if(Math.abs(keypad[numbers[i]][0]-left[0]) + Math.abs(keypad[numbers[i]][1]-left[1]) <
                        Math.abs(keypad[numbers[i]][0]-right[0]) + Math.abs(keypad[numbers[i]][1]-right[1])){
                    left[0] = keypad[numbers[i]][0];
                    left[1] = keypad[numbers[i]][1];
                    answer += "L";
                }
                else{
                    if(hand.equals("right")){

                        right[0] = keypad[numbers[i]][0];
                        right[1] = keypad[numbers[i]][1];
                        answer += "R";
                    }
                    else{

                        left[0] = keypad[numbers[i]][0];
                        left[1] = keypad[numbers[i]][1];
                        answer += "L";
                    }
                }
            }
        }


        return answer;
    }

}
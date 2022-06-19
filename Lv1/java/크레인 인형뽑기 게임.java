import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> pick = new Stack<>();

        for(int m : moves){
            for(int i=0;i<board[0].length;i++){
                if(board[i][m-1] != 0){
                    if((pick.size() > 0 && pick.peek() != board[i][m-1]) || pick.size() == 0) {
                        pick.push(board[i][m-1]);
                        board[i][m-1] = 0;
                    }
                    else {
                        board[i][m-1] = 0;
                        pick.pop();
                        answer += 2;
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
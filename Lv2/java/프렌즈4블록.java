import java.util.*;

class Solution {

    static char[][] array;
    public static int solution(int m, int n, String[] board) {
        int ans = 0;
        int count = 0;
        array = new char[m][];
        List<int[]> list = new ArrayList<int[]>();

        for(int i=0;i<board.length;i++) {
            array[i] = new char[n];
            array[i] = board[i].toCharArray();
        }

        while(true){
            for(int i=1;i<m;i++){
                for(int j=1;j<n;j++){
                    if(array[i-1][j-1] == array[i-1][j] &&
                            array[i-1][j] == array[i][j-1] &&
                            array[i][j-1] == array[i][j] &&
                            array[i][j-1] != 0){ // 4칸 같은 경우
                        for(int m1=0;m1<2;m1++) {
                            for (int n1 = 0; n1 < 2; n1++) {
                                int[] value = {i - m1, j - n1};
                                list.add(value); // 좌표 추가
                            }
                        }
                    }
                }
            }

            for (int[] num : list) {
                if(array[num[0]][num[1]] != 0) {
                    array[num[0]][num[1]] = 0;
                    count++;
                } // 지우고 count 증가
            }
            
            list.clear();

            for(int i=m-1;i>=1;i--){
                for(int j=n-1;j>=0;j--){
                    if(array[i][j] == 0){
                        for(int k=i-1;k>=0;k--){
                            if(array[k][j] != 0){
                                int a[] = {i, j};
                                int b[] = {k, j};
                                swap(a,b);
                                break;
                            }
                        }
                    }
                }
            }

            ans += count;

            if(count == 0) break;
            count = 0;
        }

        return ans;
    }

    public static void swap(int[] a, int[] b){
        char temp = array[a[0]][a[1]];
        array[a[0]][a[1]] = array[b[0]][b[1]];
        array[b[0]][b[1]] = temp;
    }
}
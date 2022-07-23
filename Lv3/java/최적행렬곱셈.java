import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int[][] matrix = new int[matrix_sizes.length][matrix_sizes.length];
        int[] d = new int[matrix_sizes.length + 1];

        for(int i=0;i< matrix_sizes.length;i++) d[i] = matrix_sizes[i][0];
        d[matrix_sizes.length] = matrix_sizes[matrix_sizes.length-1][1];

        for(int[] arr : matrix) Arrays.fill(arr, 999999999);
        for(int i=0;i<matrix_sizes.length;i++) matrix[i][i] = 0;



        for(int round=0;round<matrix_sizes.length-1;round++){
            for(int i=0;i< matrix_sizes.length-1-round;i++){
                int j = round+i+1;

                for(int k = i; k<j;k++){
                    int temp = matrix[i][k] + matrix[k+1][j] + d[i]*d[k+1]*d[j+1];
                    matrix[i][j] = Math.min(temp, matrix[i][j]);
                }
            }
        }

        return matrix[0][matrix_sizes.length-1];
    }
}
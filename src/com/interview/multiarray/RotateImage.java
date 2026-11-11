package com.interview.multiarray;

public class RotateImage {

    public void rotate(int[][] matrix){
        int len = matrix.length-1;
        int j=0;
        while( j < matrix.length/2){
            for(int i=j; j < len -j; i++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[len-i][j];
                matrix[len-i][j]=matrix[len-j][len-i];
                matrix[len-j][len-i] = matrix[i][len-j];
                matrix[i][len-j]=temp;
            }
            j++;
        }
    }

}

package com.interview.multiarray;

public class SpiralGeneration {

    public int[][] generateMatrix(int n){
        int[][] result = new int[n][n];
        int up=0;
        int down = n -1;
        int left = 0;
        int right = n-1;
        int index = 1;
        while( up <= down && left <= right){
            // iterating left to right
            for( int i=left; i <= right; i++){
                result[up][i] = index++;
            }
            up++;

            // traversing up to down
            for(int i= up; i <= down; i++){
                result[i][right] = index++;
            }
            right--;

            // right to left
            for(int i= right; i>=left; i--){
                result[down][i] = index++;
            }
            down--;

            // down to up
            for(int i= down; i >= up; i--){
                result[i][left] = index++;
            }
            left++;
        }
        return result;
    }
}

package com.interview.multiarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralPrinting {

    public List<Integer> spiralOrder(int[][] matrix){

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return Collections.EMPTY_LIST;
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length -1;
        int up =0;
        int down = matrix.length -1;

        while( up <= down && left <= right){
            for( int i=left; i <= right; i++){
               result.add(matrix[up][i]);
            }
            up++;

            // traversing up to down
            for(int i= up; i <= down; i++){
                result.add(matrix[i][right]);
            }
            right--;

            // right to left
            for(int i= right; i>=left; i--){
                result.add(matrix[down][i]);
            }
            down--;

            // down to up
            for(int i= down; i >= up; i--){
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}

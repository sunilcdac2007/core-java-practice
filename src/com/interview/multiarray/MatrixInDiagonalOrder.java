package com.interview.multiarray;

public class MatrixInDiagonalOrder {

    public void digonal(int[][] arr){
        for(int i=0; i < arr.length;i++){
            int start = i;
            int end =0;
            while(start >=0 && end < arr[0].length){
                System.out.println(arr[start][end]);
                start--;
                end++;
            }
            System.out.println();
        }

        for( int i=1; i < arr[0].length; i++){
            int start = arr.length -1;
            int end = i;
            while(start >= 0 && end < arr[0].length){
                System.out.println(arr[start][end]);
                start--;
                end++;
            }
        }
    }
}

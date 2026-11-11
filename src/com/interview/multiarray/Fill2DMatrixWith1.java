package com.interview.multiarray;

public class Fill2DMatrixWith1 {

    public void fill(int[][] arr){

        boolean row[] = new boolean[arr.length];
        boolean col[] = new boolean[arr[0].length];

        for( int i=0; i < arr.length; i++){
            for( int j =0; j< arr[0].length; j++){
                if(arr[i][j] ==1){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for( int i=0; i < arr.length; i++){
            for( int j =0; j< arr[0].length; j++){
               if(row[i] || col[j]){
                   arr[i][j] = 1;
               }
            }
        }


    }

    static void main() {
        int[][] arr = {{1,0},{0,0}};

        Fill2DMatrixWith1 fill = new Fill2DMatrixWith1();
        fill.fill(arr);
        System.out.println(arr);
    }


}

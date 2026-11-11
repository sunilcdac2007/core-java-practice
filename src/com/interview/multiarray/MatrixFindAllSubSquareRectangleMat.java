package com.interview.multiarray;

public class MatrixFindAllSubSquareRectangleMat {

    public void printSumOfAllSqureMat(int[][] arr){
        for( int len = 1; len <= arr.length; len++){
            for(int i=0; i < arr.length-len + 1; i++){

                for(int j=0; j < arr[i].length -len+1; j++){
                    int sum =0;
                    for(int k =i; k < j + len; k++){
                        for(int m =j; m < j + len; m++){
                            sum = sum + arr[k][m];
                        }
                    }
                    System.out.println("start i"+i+" end j"+j+ "sum "+sum);
                }
            }
        }
    }
   public void printSumAllReactangleMat(int arr[][]){

       for( int rlen = 1; rlen <= arr.length; rlen++){
         for(int clen = 1; clen <=arr[0].length; clen++) {
             for (int i = 0; i < arr.length - rlen + 1; i++) {

                 for (int j = 0; j < arr[i].length - clen + 1; j++) {
                     int sum = 0;
                     for (int k = i; k < j + rlen; k++) {
                         for (int m = j; m < j + clen; m++) {
                             sum = sum + arr[k][m];
                         }
                     }
                     System.out.println("start i" + i + " end j" + j + "sum " + sum);
                 }
             }
         }
       //
       }

   }


}

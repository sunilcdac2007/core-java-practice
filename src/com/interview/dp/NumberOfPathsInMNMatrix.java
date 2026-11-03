package com.interview.dp;

public class NumberOfPathsInMNMatrix {

    int countPathRec(int m, int n){
        if(m ==1 || n ==1) return 1;
        return countPathRec(m-1,n) + countPathRec(m, n-1);
    }

    int countPathDP(int m, int n){
        int[][] dpPath = new int[m][n];
        for(int i=0; i < m; i++){
            dpPath[i][0] =1;
        }
        for(int i=0; i< n; i++){
            dpPath[0][i] = 1;
        }
       for(int i=1; i< m; i++){
           for(int j=1; j < n; j++){
               dpPath[i][j] = dpPath[i-1][j] + dpPath[i][j-1];
           }
       }
       return dpPath[m-1][n-1];
    }


}

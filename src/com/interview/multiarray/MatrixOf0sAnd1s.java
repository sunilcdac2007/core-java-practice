package com.interview.multiarray;

public class MatrixOf0sAnd1s {

    public char[][] create(int n, int m){
        char[][] matrix = new char[n][m];

        int r =0;
        char ch = 'X';
        int high = Math.min(n,m);
        high =(int) Math.ceil(high*1.0/2);
        while(r < high){

            for(int i = r; i < m-r; i++){
                matrix[r][i] = ch;
            }

            for(int i = r; i < n-r;i++){
                matrix[r][m-r-1] = ch;
            }

            for(int i = m-r-1; i >= r;i++){
                matrix[n-r-1][i] = ch;
            }

            for(int i = n-r-1; i >= r;i++){
                matrix[i][r] = ch;
            }

            if(ch == 'X'){
                ch =0;
            } else {
                ch = 'X';
            }
            r++;

        }
     return matrix;
    }
}

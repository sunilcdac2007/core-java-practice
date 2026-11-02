package com.interview.dp;

public class Immutable2DSumRangeQuery {

    private int dp[][];
    public Immutable2DSumRangeQuery(int[][] matrix){
        int row=0;
        int col =0;
        if(matrix.length != 0){
            row = matrix.length;
            col = matrix[0].length;
        }
        dp = new int[row+1][col+1];
        for(int index =1; index < dp.length; index++){
            for(int j =1; j < dp[0].length; j++){
                dp[index][j] = dp[index-1][j] + dp[index][j-1] + matrix[index-1][j-1] - dp[index-1][j-1];
            }
        }

    }

    public int sumQuery(int row1, int col1, int row2, int col2){
        row1 ++;
        col1++;
        row2++;
        col2++;
        return dp[row2][col2] - dp[row1-1][col2] - dp[row2][col1-1] + dp[row1 -1][col1-1];
    }

    static void main() {
        int[][] matrix = {
                {3,0,1},
                {5,6,3},
                {4,7,9}
        };
        Immutable2DSumRangeQuery query = new Immutable2DSumRangeQuery(matrix);
        int val = query.sumQuery(1,1,2,2);
        System.out.println(val);
    }
}

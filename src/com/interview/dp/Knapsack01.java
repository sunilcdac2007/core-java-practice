package com.interview.dp;

public class Knapsack01 {

    public int bottomUpDP(int val[], int wt[], int w){
        int dp[][] = new int[val.length+1][w+1];
        for(int i=0; i <= val.length; i++){
            for(int j =0; j <= w; j++){
                if(i ==0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }
                if(j - wt[i-1] >= 0){
                    dp[i][j] = Math.max(
                            dp[i-1][j],
                            dp[i-1][j-wt[i-1]] + val[i-1]
                    );
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[val.length][w];
    }
}

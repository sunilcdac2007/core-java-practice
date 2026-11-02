package com.interview.dp;

public class CutRodToMinimizeCost {

    public int cutRodToMinimizeCost(int[] markings, int total){

        int dp[][] = new int[total+1][total+1];
        for(int i =0; i < dp.length; i++){
            for(int j =0; j< dp.length; j++){
                dp[i][j] = -1;
            }
        }
        return cutRodToMinimizeCost(markings, 0, total, dp);
    }

    private int cutRodToMinimizeCost(int[] markings, int start, int end, int[][] dp) {
    if(dp[start][end] != -1) return dp[start][end];
    int i;
    for(i=0; i < markings.length; i++){
        if(start < markings[i]){
            break;
        }
    }
    if(i == markings.length){
        dp[start][end] = 0;
        return 0;
    }
    int j;

    for(j=markings.length-1; j>=0; j--){
        if(end > markings[j]){
            break;
        }
    }
    if(j == -1){
        dp[start][end] = 0;
        return 0;
    }
    if(i == j){
        dp[start][end] = end - start;
        return end-start;
    }

    int cost = end - start;
    int minCost = Integer.MAX_VALUE;
    for(int k=i; k <=j; k++){

        int cost1= cutRodToMinimizeCost(markings, start, markings[k], dp);
        int cost2 = cutRodToMinimizeCost(markings, markings[k], end, dp);
        if(cost1 == Integer.MAX_VALUE || cost2 == Integer.MAX_VALUE){
            continue;
        }
        if(minCost > cost1 + cost2){
            minCost = cost1 + cost2;
        }
    }
    if(minCost == Integer.MAX_VALUE){
        dp[start][end] = Integer.MAX_VALUE;
        return dp[start][end];
    }

    dp[start][end] = cost + minCost;
    return dp[start][end];

    }

    static void main() {
        int[] markings = {1,2,5};
        int total = 6;
        CutRodToMinimizeCost cut = new CutRodToMinimizeCost();
        int val = cut.cutRodToMinimizeCost(markings, total);
        System.out.println(val);
    }

}

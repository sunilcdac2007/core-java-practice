package com.interview.dp;

import java.util.Deque;
import java.util.LinkedList;

public class StockBuySaleWithKTransaction {

    static void main() {
        int[] prices = {2,5,7,1,4};
        int transaction = 2;
        int maxprofit = maxProfitWithK(prices, transaction);
        System.out.println(maxprofit);
    }

    public static int maxProfitWithK(int[] prices, int transaction){
          int[][] dpMaxProfit = new int[transaction+1][prices.length];
          for( int i=1; i <= transaction; i++){
              int maxDiff = -prices[0];
              for(int j=1; j< prices.length; j++){
                  dpMaxProfit[i][j] = Math.max( dpMaxProfit[i][j-1], prices[j] + maxDiff);
                  maxDiff = Math.max(maxDiff,  dpMaxProfit[i-1][j]- prices[j]);
              }

          }
        printActualSolution(dpMaxProfit, prices);
     return dpMaxProfit[transaction][prices.length-1];
    }

    public static void printActualSolution(int dp[][], int prices[]){

        int i = dp.length -1;
        int j = dp[0].length -1;
        Deque<Integer> stack = new LinkedList<>();
        while(true){
            if(i==0 || j ==0){
                break;
            }
            if(dp[i][j] == dp[i][j-1]){
                j = j-1;
            } else {
                stack.addFirst(j);
                int maxDiff = dp[i][j] - prices[j];
                for(int k=j-1; k>= 0 ;k--){
                    if(dp[i-1][k] - prices[k] == maxDiff){
                        i = i-1;
                        j=k;
                        stack.addFirst(j);
                        break;
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            System.out.println(" Buy at price "+ prices[stack.pollFirst()]);
            System.out.println(" sale at price "+ prices[stack.pollFirst()]);
        }

    }

    public int maxProfitSlowSolution(int[] prices, int transaction){
        if(transaction ==0 || prices.length ==0) return 0;

        int[][] dpArr = new int[transaction+1][prices.length];
        for(int i=1; i <= transaction; i++){
            for(int j=1; j < prices.length; j++){
                int maxVal =0;
                for(int m=0; m < j; m++){
                    maxVal = Math.max(maxVal, prices[j]- prices[m] + dpArr[i-1][m]);
                }
                dpArr[i][j] = Math.max(dpArr[i][j-1], maxVal);
            }
        }
        return dpArr[transaction][prices.length-1];
    }


}

package com.interview.dp;

import java.util.ArrayList;
import java.util.List;

public class CoinChanging {
// [1,2,3,5]  total =10
    public int numberOfSolutions(int total, int coins[]){
        int[][] dp = new int[coins.length+1][total+1];
        for(int i=0; i<= coins.length; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i <= coins.length; i++){
            for(int j=1; j<= total; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
            }
        }
        return dp[coins.length][total];
    }

    public int numberOfSolutionOnSpace(int total, int arr[]){
        int temp[] = new int[total+1];
        temp[0] = 1;
        for(int i=0; i< arr.length; i++){
            for(int j=1; j <=total; j++){
                if(j >= arr[i]){
                    temp[j]= temp[j] + temp[j-arr[i]];
                }
            }
        }
        return temp[total];
    }

    public void printCoinChanging(int total, int[] coins){
        List<Integer> result = new ArrayList<>();
        printCoin(result, total, coins,0);
    }

    private void printCoin(List<Integer> result, int total, int[] coins, int pos) {

        if(total ==0){
            for( int r: result){
                System.out.print(r +" ");
            }
            System.out.println();
        }

        for(int i =pos; i < coins.length; i++){
            if(total >= coins[i]){
             result.add(coins[i]);
             printCoin(result, total-coins[i], coins, i);
             result.remove(result.size()-1);
            }
        }

    }

    static void main() {
        CoinChanging coinChanging = new CoinChanging();
        int coins[] = {1,2,3};
        int total = 4;
      // int val = coinChanging.numberOfSolutions(total,coins);
      int val = coinChanging.numberOfSolutionOnSpace(total, coins);
        System.out.println(val);
    }
}

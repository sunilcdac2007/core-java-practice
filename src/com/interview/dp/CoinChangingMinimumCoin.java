package com.interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChangingMinimumCoin {

    public int minimumCoinTopDown(int total, int coins[], Map<Integer, Integer> dpMap){
       if(total ==0) return 0;
       if(dpMap.containsKey(total)) return dpMap.get(total);
       int min = Integer.MAX_VALUE;

       for(int i=0; i < coins.length; i++){
           if(coins[i] <= total){
            int val = minimumCoinTopDown(total -coins[i], coins, dpMap);
            if(val < min){
                min = val;
            }
           }
       }
       min =  min == Integer.MAX_VALUE ? min: min+1;
       dpMap.put(total, min);
       return min;
    }

    public int minmumCoinBottomUp(int total, int coins[]){
        int T[] = new int[total+1];
        int R[] = new int[total+1];
        T[0] = 0;
        for( int i=1; i <=total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }

        for(int i=0; i < coins.length; i++){
            for(int j=1; j<=total; j++){
                if(j >= coins[i]){
                    if(T[j-coins[i]] +1 < T[j]){
                        T[j] = 1 + T[j-coins[i]];
                        R[j] = i;
                    }
                }
            }
        }
        return T[total];
    }

    public int minimumCoinBottomUp(int total, int[] coins) {
        int[] dp = new int[total + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int amount = 1; amount <= total; amount++) {
            for (int coin : coins) {
                if (coin <= amount &&
                        dp[amount - coin] != Integer.MAX_VALUE) {

                    dp[amount] = Math.min(
                            dp[amount],
                            dp[amount - coin] + 1
                    );
                }
            }
        }

        return dp[total];
    }

    static void main() {
        int[] coins = {1,2,3};
        int total =4;
        Map<Integer,Integer> dpMap = new HashMap<>();
        CoinChangingMinimumCoin coin = new CoinChangingMinimumCoin();
        // int val = coin.minimumCoinTopDown(total, coins,dpMap);
         int val =coin.minimumCoinBottomUp(total, coins);
        System.out.println(val);
    }

}

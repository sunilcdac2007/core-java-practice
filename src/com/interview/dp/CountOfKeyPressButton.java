package com.interview.dp;

import java.util.List;

public class CountOfKeyPressButton {

     public int countAsREc(int num){
         List lst = null;
         if(num < 7) return num;
         int max = Integer.MIN_VALUE;
         int result = 0;
         for(int index = num-3; index > 0; index--){
             result = (num-index -1)* countAsREc(index);
             if(max < result){
                 max = result;
             }
         }
         return max;
     }

     public int countAs(int num){
         if(num < 7) return num;
         int dp[] = new int[num+1];
         for(int i=1; i <7; i++){
             dp[i] = i;
         }
         for(int i=7; i <=num ; i++){
             for(int j = i-3; j>0; j--){
                 dp[i] = Math.max(dp[i], dp[j]*(i-j-1));
             }
         }
        return dp[num];
     }

}

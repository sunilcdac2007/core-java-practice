package com.interview.dp;

public class CutRodToMaxProfit {

    public int maxProfit(int prices[]){
        int max[] = new int[prices.length+1];
        for( int len=1; len <= prices.length; len++){
            for ( int  j = len; j<= prices.length; j++){
                max[j] = Math.max(max[j], max[j-1]+ prices[len-1]);
            }
        }
        return max[prices.length];
    }
}

package com.interview.dp;

public class EggDropping {
    static void main() {
        EggDropping eggDropping = new EggDropping();
      int val =  eggDropping.calcualte(2,7);
        System.out.println(val);
    }
    public int calcualte(int eggs, int floors){
        int dp[][] = new int[eggs+1][floors+1];
        int c=0;
        for(int i=0; i <= floors; i++){
            dp[1][i] = i;
        }
        for( int egg = 2; egg <= eggs; egg++ ){
            for (int floor =1; floor <= floors; floor++){
                dp[egg][floor] = Integer.MAX_VALUE;
                for(int index =1; index <= floor; index++){
                    c = 1 + Math.max(dp[egg-1][index-1], dp[egg][floor-index]);
                    if(c < dp[egg][floor]){
                        dp[egg][floor] = c;
                    }
                }

            }
        }
        return dp[eggs][floors];
    }
}

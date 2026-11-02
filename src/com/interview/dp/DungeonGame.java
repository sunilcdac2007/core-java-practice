package com.interview.dp;

public class DungeonGame {

    public int calculateMinimumDP(int[][] dungeon){

        if(dungeon.length == 0 || dungeon[0].length ==0){
            return 0;
        }
        int[][] health = new int[dungeon.length][dungeon[0].length];
        int m=dungeon.length-1;
        int n = dungeon[0].length-1;
        health[m][n] =  Math.max(1- dungeon[m][n], 1);
        for( int i = m-1; i >=0; i--){
            health[i][n] = Math.max(health[i+1][n]-dungeon[i][n],1);
        }

        for( int j = n-1; j>=0; j--){
            health[m][j] = Math.max(health[m][j+1] - dungeon[m][j],1);
        }

        for(int i = m-1; i >=0; i--){
               for( int j= n-1; j>=0; j--){
                   health[i][j] =  Math.min (Math.max(health[i+1][j] - dungeon[i][j], 1),
                                             Math.max(health[i][j+1] - dungeon[i][j],1));
               }
        }
        return health[0][0];
    }
}

package com.interview.dp;

public class MinCostPath {

    public int minCostPath(int[][] cost, int row, int col){
        int[][] tempArr = new int[row+1][col+1];
        int sum =0;
        for(int i=0; i< col ;i++){
            sum = sum+ cost[0][i];
            tempArr[0][i]=sum;
        }
        sum=0;
        for(int i=0; i< row ;i++){
            sum = sum+ cost[i][0];
            tempArr[i][0]=sum;
        }

        for(int i=1; i <=row; i++){
            for(int j=1; j<= col; j++){
                tempArr[i][j] = cost[i][j] + Math.min(
                        Math.min(tempArr[i-1][j], tempArr[i][j-1]),
                        tempArr[i-1][j-1]
                );
            }
        }
        return tempArr[row][col];
    }

    public int minCostRec(int cost[][], int m, int n, int x, int y){
        if(x >m || y >n){
            return Integer.MAX_VALUE;
        }
        if(x == m && y == n){
            return cost[m][n];
        }
        int t1 = minCostRec(cost, m,n, x+1, y);
        int t2 = minCostRec(cost, m,n, x+1, y+1);
        int t3 = minCostRec(cost, m,n, x, y+1);
        return cost[x][y] + Math.min(Math.min(t1,t2),t3);

    }
}

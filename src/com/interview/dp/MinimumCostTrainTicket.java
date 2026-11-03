package com.interview.dp;

public class MinimumCostTrainTicket {

    public int minCost(int ticket[][]){
        int dpCost[] = new int[ticket.length];
        int dpIndexCost[] = new int[ticket.length];
        dpIndexCost[0] = -1;
        for(int i=1; i < ticket.length; i++){
            dpCost[i]= ticket[0][i];
            dpIndexCost[i] = i-1;
        }

        for(int i=1; i< ticket.length; i++){
            for(int j= i+1; j< ticket.length; j++){
                if(dpCost[j] > dpCost[i] + ticket[i][j]){
                    dpCost[j] = dpCost[i] + ticket[i][j];
                    dpIndexCost[j] = i;
                }
            }
        }
        return dpCost[ticket.length-1];
    }
}

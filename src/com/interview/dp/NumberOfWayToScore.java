package com.interview.dp;

public class NumberOfWayToScore {
    // [1,2,3]  score =4
    public static int  scoreWay(int[] score, int total){

        int[] dpArr = new int[total+1];
        dpArr[0] = 1;
        for(int i=0; i < score.length; i++){
            for(int j=1; j <= total; j++){
                if(j >= score[i]){
                    dpArr[j] = dpArr[j] + dpArr[j - score[i]];
                }
            }
        }
        return dpArr[total];
    }

    static void main() {

        int[] score = {1,2,3};
        // 1X4 = 4
        // 2+ 1+1
        // 2 + 2
        // 3 + 1
       int numOfWay = scoreWay(score,4);
        System.out.println(numOfWay);
    }
}

package com.interview.dp;

import java.util.Arrays;

public class WeightedJobsSchedulingMaxProfit {

  //  (String s1, String s2) -> Integer.compare(s1.length(), s2.length())

    public int maximumProfit(Job[] jobs){

        int dp[] = new int[jobs.length];
        Arrays.stream(jobs).sorted( (j1, j2)->{
            if(j1.end <= j2.end){
                return -1;
            }else
                return 1;
        });
        dp[0] = jobs[0].profit;
        for(int i=1; i < jobs.length; i++){
            dp[i] = Math.max(jobs[i].profit, dp[i-1]);
            for(int j=i-1; j>=0;j--){
                if(jobs[j].end <= jobs[i].start){
                    dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
                    break;
                }
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for(int val: dp){
            if(maxVal < val){
                maxVal = val;
            }
        }
        return maxVal;
    }

    static void main() {
        Job[] jobs = {
                new Job(1,3,5)  ,
                new Job(2,5,6),
                new Job(4,6,5),
                new Job(6,7,4),
                new Job(5,8,11),
                new Job(7,9,2)
        };
        WeightedJobsSchedulingMaxProfit prfit = new WeightedJobsSchedulingMaxProfit();
        int profit = prfit.maximumProfit(jobs);
        System.out.println(profit);

    }

}

class Job{

    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

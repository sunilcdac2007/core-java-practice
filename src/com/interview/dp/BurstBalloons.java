package com.interview.dp;

public class BurstBalloons {

    public int maxCoinsBottomUpDP(int[] nums){
        // [11,3,7,9,8]
       int[][] T = new int[nums.length][nums.length];
       for(int len =1; len <= nums.length; len++){
           for(int i=0; i<= nums.length-len; i++){

               int j = i + len -1;
               for(int k =i; k<=j;k++){
                   int leftValue = 1;
                   int rightValue = 1;
                   if(i != 0){
                       leftValue = nums[i-1];
                   }

                   if(j != nums.length -1){
                       rightValue = nums[j+1];
                   }

                   int before = 0;
                   int after = 0;
                   if(i != k){
                       before = T[i][k-1];
                   }

                   if(k != j){
                       after = T[k+1][j];
                   }
                   T[i][j] = Math.max(leftValue * nums[k] * rightValue + after
                   + before, T[i][j]);
               }
           }
       }

       return T[0][nums.length-1];
    }

    // [11,3,7,9,8]
    //  [1,11,3,7,9,8,1]

   /* public int maxCoinsRec(int nums[]){

    }*/

    //  [1,11,3,7,9,8,1]
    // [1,3,7,9,8,1]
    // [1,7,9,8,1]
    // [1,9,8,1]
    // [1,8,1]
    // [1,1]
    /*private int maxCoinRecUtil(int[] numsTemp) {



    }

    private int[] formNewArray(int[] nums, int notIncludedIndex) {


    }*/


    static void main() {
        int[] coins = {11,3,7,9,8};
        BurstBalloons burstBalloons = new BurstBalloons();
       int val = burstBalloons.maxCoinsBottomUpDP(coins);
     // int val = burstBalloons.maxCoinsRec(coins);
        System.out.println(val);
    }
}

package com.interview.array;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums){
        int[] dp = new int[3];
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            boolean foundNotTriplate = false;
             for( int j =0; j < len; j++){
                 if(dp[j] >= nums[i]){
                     dp[j] = nums[i];
                     foundNotTriplate = true;
                     break;
                 }
             }
             if(!foundNotTriplate){
                 dp[len++] = nums[i];
             }
             if(len == 3){
                 return true;
             }
        }
        return false;
    }

    static void main() {
        int[] arr = {1,2,3,4,5};
        IncreasingTripletSubsequence inc = new IncreasingTripletSubsequence();
        inc.increasingTriplet(arr);
    }
}

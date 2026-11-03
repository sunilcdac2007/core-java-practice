package com.interview.dp;

public class LongestIncreasingSubsequence {

 public static int lognestSubsequence(int arr[]){
     //[23,10,22,5,33,8,9,11,50]
     int dp[] = new int[arr.length];
     int acualSoltuion[] = new int[arr.length];
     for(int i=0; i < arr.length; i++){
         dp[i] = 1;
         acualSoltuion[i] = i;
     }

     for(int i=1; i < arr.length; i++){
         for( int j=0; j< i;j++){
             if(arr[i] > arr[j]){
                 if(dp[j] +1 > dp[i]){
                     dp[i] = dp[j] +1;
                     acualSoltuion[i] = j;
                 }
             }
         }
     }
     int maxIndex = 0;
     for(int i=0; i < dp.length; i++){
         if(dp[i] > maxIndex){
             maxIndex = i;
         }
     }
     return dp[maxIndex];
 }
 public static int logestSubSeqRec(int nums[]){
     int maxLen =0;
     for(int i=0; i < nums.length-1; i++){
         int len = logestSubSeqRecursiv(nums, i+1, nums[i]);
         if(len > maxLen){
             maxLen = len;
         }
     }
     return maxLen;
 }

    private static int logestSubSeqRecursiv(int[] nums, int pos, int lastNum) {
     if(pos == nums.length){
         return 0;
     }
     int temp1=0;
     if(nums[pos] > lastNum){
         temp1 = 1 + logestSubSeqRecursiv(nums, pos+1, nums[pos]);
     }
     int temp2 = logestSubSeqRecursiv(nums, pos+1, lastNum);
     return Math.max(temp1, temp2);
     }

    static void main() {
        int[] nums = {23,10,22,5,33,8,9,11,50};

       int val = lognestSubsequence(nums);
        int val1 = logestSubSeqRec(nums);
        System.out.println(val +"  "+ val1);
    }
}

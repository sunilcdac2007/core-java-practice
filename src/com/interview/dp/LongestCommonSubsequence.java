package com.interview.dp;

public class LongestCommonSubsequence {

    static void main() {
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        // OUT= ADHR == 4
        //int val=lcs(str1.toCharArray(), str2.toCharArray(), 0 , 0);
       int val = lcsDP(str1.toCharArray(), str2.toCharArray());
        System.out.println(val);
    }
    private static int lcs(char[] str1, char[] str2, int index1, int index2) {
        if(str1.length == index1 || str2.length == index2) return 0;
        if(str1[index1] == str2[index2]){
            return 1 + lcs(str1,str2, index1+1, index2+1);
        }
        return Math.max(
                lcs(str1,str2, index1+1, index2),lcs(str1,str2, index1, index2+1)
        );
    }
  private static int lcsDP(char[] str1, char[] str2){
        int dp[][] = new int[str1.length+1][str2.length+1];
        int maxCommonSeque=0;
        for(int i=1; i <= str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                if(maxCommonSeque< dp[i][j]){
                    maxCommonSeque = dp[i][j];
                }
            }
        }
        return maxCommonSeque;
  }

}

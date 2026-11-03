package com.interview.dp;

public class LongestPalindromicSubSeq {

    public static int longPalindrom(char[] str){
        int[][] dp = new int[str.length][str.length];
        for(int i=0; i< str.length; i++){
            dp[i][i] =1 ;
        }

        for(int l=2; l<=str.length; l++){
            for(int i=0; i < str.length-l+1 ; i++){
                int j = i + l -1;
                if(l==2 && str[i] == str[j]){
                    dp[i][j] = 2;
                } else if(str[i] == str[j]){
                    dp[i][j] = dp[i + 1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][str.length-1];
    }

    public int calculateRecursive(char[] str, int start, int len){
        if(len==1) return 1;
        if(len==0) return 0;
        if(str[start] == str[start+len-1])
             return 2 + calculateRecursive(str, start+1, len-2);
        else
            return Math.max(
                    calculateRecursive(str, start+1, len-1),
                    calculateRecursive(str, start, len-1)
            );
    }

    static void main() {
        String str = "dbdba";
       int val= longPalindrom(str.toCharArray());
        System.out.println(val);
    }
}

package com.interview.dp;

public class LongestCommonSubString {

    static void main() {
        String str1 = "abcdef";
        String str2 = "zcdemf";
       int val = commonSubString(str1.toCharArray(), str2.toCharArray());
       int val2 = commonSubStrRec(str1.toCharArray(), str2.toCharArray(), str1.length()-1, str2.length()-1, false);
        System.out.println(val +" recu "+ val2);
    }

    private static int commonSubString(char[] str1, char[] str2) {

        int dp[][] = new int[str1.length+1][str2.length+1];
        int maxSub = 0;

        for(int i=1; i <= str1.length; i++){
            for( int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(dp[i][j] > maxSub){
                        maxSub=dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp);
        return maxSub;
    }

    private static int commonSubStrRec(char[] str1, char[] str2, int pos1, int pos2, boolean checkEqual){

        if(pos1 == -1 || pos2 == -1){
            return 0;
        }
        if(checkEqual){

            if(str1[pos1] == str2[pos2]){
                return 1 + commonSubStrRec(str1, str2, pos1-1, pos2-1, true);
            } else {
                return 0;
            }
        }
        int r1 =0;
        if(str1[pos1] == str2[pos2]){
            r1 = 1 + commonSubStrRec(str1, str2, pos1-1, pos2-1, true);
        }

        int r2 = Math.max(commonSubStrRec(str1,str2, pos1-1, pos2, false),
                commonSubStrRec(str1,str2, pos1, pos2-1, false));

        return Math.max(r1,r2);
    }
}

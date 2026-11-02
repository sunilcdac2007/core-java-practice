package com.interview.dp;

public class EditDistance {

    static void main() {
        String str1 = "azxde";
        String str2 = "abcde";
       //int val = editDistance(str1.toCharArray(),str2.toCharArray(), 0,0);
       int val = editDistanceDP(str1,str2);
        System.out.println(val);
    }

    private static int editDistance(char[] str1, char[] str2, int len1, int len2) {

        if(str1.length == len1){
            return str2.length -len2;
        }
        if(str2.length == len2)
            return str1.length-len1;

       return  min ((editDistance(str1,str2, len1 + 1, len2+1) + (str1[len1] == str2[len2] ? 0: 1)),
               editDistance(str1,str2, len1, len2+1) +1,
               editDistance(str1,str2, len1+1, len2) +1 );

    }

    private static int min(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }

    public static int editDistanceDP(String str1, String str2){

        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i = 0; i< str2.length(); i++){
            dp[0][i] = i;
        }

        for(int i = 0; i < str1.length(); i++){
            dp[i][0] = i;
        }

        for(int i=1; i <=str1.length(); i++){
            for(int j=1; j <= str2.length(); j++){

                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + min(dp[i-1][j-1],
                                    dp[i-1][j],
                                     dp[i][j-1]);
                }
            }
        }
        printActualEdits(dp, str1.toCharArray(), str2.toCharArray());
     return dp[str1.length()][str2.length()];
    }
  public static void printActualEdits(int dp[][], char[] str1, char[] str2){
        int i = dp.length-1;
        int j = dp[0].length-1;

        while(true){
            if(i ==0 || j == 0){
                break;
            }
            if(str1[i-1] == str2[j-1]){
                i = i-1;
                j= j-1;
            } else if (dp[i][j] == dp[i-1][j-1] +1){
                System.out.println("edit "+ str2[j-1] +" in str2 to "+ str1[i-1] +" in str1");
                i = i-1;
                j = j-1;
            } else if(dp[i][j] == dp[i-1][j] +1){
                System.out.println(" delete in string1 "+ str1[i-1]);
                i = i-1;
            } else if (dp[i][j] == dp[i][j-1] +1){
                System.out.println("delete string2 "+ str2[j-1]);
                j = j-1;
            }
        }
  }


}

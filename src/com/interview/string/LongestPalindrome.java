package com.interview.string;

public class LongestPalindrome {

    public int longestPalindrome(char[] arr){
        int longestSubStr = 1;
        for( int i =0; i < arr.length; i++){
            int x,y;
            int palindrome=0;
            x = i;
            y = i +1;
            while( x >=0 && y < arr.length && arr[x] == arr[y]){
                x--;
                y++;
                palindrome = palindrome + 1;
            }
            longestSubStr = Math.max(longestSubStr,palindrome );

            x = i -1;
            y = i +1;

            while( x >=0 && y < arr.length && arr[x] == arr[y]){
                x--;
                y++;
                palindrome = palindrome + 1;
            }

            longestSubStr = Math.max(longestSubStr,palindrome );

        }
       return longestSubStr;
    }

    public int longestPalinDynamic(char[] str){

        boolean dp[][] = new boolean[str.length][str.length];
        for(int i=0; i< dp.length; i++){
            dp[i][i] = true;
        }

        int max = 1;

        for( int len =2; len <=str.length; len++){
            int tempLen =0;
            for( int i=0 ; i < str.length-len +1; i++){
                int j = i +len -1;
                tempLen = 0;
                if(len == 2) {
                    if (str[i] == str[j]) {
                        dp[i][j] = true;
                        tempLen = 2;
                    }
                }else {
                        if( str[i] == str[j]  && dp[i+1][j-1]){
                            dp[i][j] = true;
                            tempLen= j-i +1;
                    }
                }
                if(tempLen > max){
                    max = tempLen;
                }
            }
        }

        return max;
    }
    static void main() {

        String str = "abbababbaaa";

        LongestPalindrome longes = new LongestPalindrome();
        System.out.println(longes.longestPalindrome(str.toCharArray()));

        System.out.println(longes.longestPalinDynamic(str.toCharArray()));
    }

}


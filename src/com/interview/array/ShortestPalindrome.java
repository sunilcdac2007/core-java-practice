package com.interview.array;

import java.util.Locale;

public class ShortestPalindrome {





    private char[] createInput(String s){
        char[] input = new char[2* s.length() +1];
        int index = 0;

        for(char ch: s.toCharArray()){
            input[index++] = ch;
        }
        input[index++] = '$';

        for(  int i = s.length()-1; i >= 0; i--){
            input[index++] = s.charAt(i);
        }
        return input;
    }

    private int paternMatch(char[] arr){

        int dp[] = new int[arr.length];
        int j = 1;
        int i=0;
        dp[0] = 0;
        while( j < arr.length){
            if (arr[i] == arr[j]) {
                dp[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = dp[i - 1];
                } else {
                    dp[j] = 0;
                    j++;
                }
            }
        }
        return dp[arr.length-1];
    }

    public String shortesPalindrome( String s){
        char[] arr = createInput(s);
        int val = paternMatch(arr);
        StringBuilder build = new StringBuilder();
        int remaining = s.length() - val;
        int i = s.length() -1;
        while(remaining > 0){
            build.append(s.charAt(i));
            i--;
            remaining--;
        }
        build.append(s);
        return build.toString();
    }

    static void main() {
        String s = "abcd";
        s="cbdbca";
        ShortestPalindrome palin = new ShortestPalindrome();
        String s1 =  palin.shortesPalindrome(s);
        System.out.println("s1:: "+ s1);

    }
}

package com.interview.dp;


import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

    static void main() {
        String str ="ABC";//"AAB"; //"ABC";
        Set<String> result = new HashSet<>();
        permute(str, 0, str.length()-1,result);
    }

    private static void permute(String str, int startIndex, int endIndex,Set<String> result) {

        if(startIndex == endIndex){
            if(!result.contains(str)) {
                result.add(str);
                System.out.println(str);
            }
            return;
        }
        Set<Character> used = new HashSet<>();
            for(int i=0; i <= endIndex; i++){
                char ch = str.charAt(i);
                // Skip if this character has already been used at this level
                if (used.contains(ch)) {
                    continue;
                }
                used.add(ch);
               str = swapStr(str, startIndex, i);
               permute(str, startIndex+1, endIndex,result);
               str = swapStr(str, startIndex, i);
               //used.remove(used.size()-1);
            }

    }

    private static String swapStr(String str, int startIndex, int swapIndex) {

        char[] strArr = str.toCharArray();
        char temp = strArr[startIndex];
        strArr[startIndex] = strArr[swapIndex];
        strArr[swapIndex]=temp;
        return String.valueOf(strArr);
    }
}

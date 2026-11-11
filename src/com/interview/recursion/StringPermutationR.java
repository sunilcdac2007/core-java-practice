package com.interview.recursion;


import java.util.HashSet;
import java.util.Set;

public class StringPermutationR {

    static void main() {
        String text = "ABC";
        Set<String> result = new HashSet<>();
        permuter(text, 0, text.length()-1, result);
    }

    private static void permuter(String text, int startIndex, int endIndex, Set<String> result) {

        if(startIndex == endIndex){
            if(!result.contains(text)){
                result.add(text);
                System.out.println(text);
            }
            return;
        }
        Set<Character> used = new HashSet<>();
        for( int i=0; i < text.length(); i++){
            if(used.contains(text.charAt(i))){
                continue;
            }
           text= swapText(text, startIndex, i);
            permuter(text, startIndex+1, endIndex, result);
           text = swapText(text, startIndex, i);
        }
    }

    private static String swapText(String text, int startIndex, int endIndex) {
        char[] strArr = text.toCharArray();
        char temp = strArr[startIndex];
        strArr[startIndex] = strArr[endIndex];
        strArr[endIndex]=temp;
        return String.valueOf(strArr);
    }
}

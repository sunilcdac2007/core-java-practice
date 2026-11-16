package com.interview.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithoutRepeatingChar {


    public int lenghtOflong(String str){
        Set<Character> uniqueSet = new HashSet<>();
        int maxSize = 0;
        int start = 0;
        for( int i =0 ; i < str.length(); i++){
            if(!uniqueSet.contains(str.charAt(i))){
                uniqueSet.add(str.charAt(i));
                if(uniqueSet.size()> maxSize){
                    maxSize = uniqueSet.size();
                }
            }  else {
                while(str.charAt(i) != str.charAt(start)){
                    uniqueSet.remove(str.charAt(start));
                    start++;
                }
                start++;
            }
        }

        return maxSize;
    }

    static void main() {
        String str = "abcdedaadxyzioprewgf";
        LongestSubStrWithoutRepeatingChar rep = new LongestSubStrWithoutRepeatingChar();
        System.out.println(rep.lenghtOflong(str));
    }
}

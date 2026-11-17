package com.interview.string;

public class SubStringSearch {

    static void main() {
        String text = "ABCDAB";
        String pattern = "ABC";

         SubStringSearch search = new SubStringSearch();

        System.out.println(search.hasSubString(text.toCharArray(), pattern.toCharArray()));

    }

    public boolean hasSubString(char[] text, char[] pattern){

        int i =0;
        int j =0;
        int k =0;

        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++; j++;
            }else {
                j = 0;
                k++;
                i = k;
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }

private int[] computeArray(char[] pattern){
        int[] lps = new int[pattern.length];
        int index = 0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else {
                if(index != 0){
                    index = lps[index-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
}


public boolean KMP(char[] text, char[] pattern){
        int lps[] = computeArray(pattern);
        int i =0;
        int j = 0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            } else {
                if(j != 0){
                    j = lps[j-1];
                } else {
                    i++;
                }
            }

        }

    if(j == pattern.length) return true;
    return false;
}
}

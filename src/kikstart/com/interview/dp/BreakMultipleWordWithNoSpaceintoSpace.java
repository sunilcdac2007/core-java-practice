package com.interview.dp;

import java.util.*;

public class BreakMultipleWordWithNoSpaceintoSpace {

    static void main() {
        String str = "iamjavadeveloper";
        Set<String> dic = Set.of("i","am","java","developer");
      // String result = breakWord(str.toCharArray(), 0, dic);
      //     String result = breakWordDP(str, dic);
      String result = String.valueOf(wordBreakTopDown(str, dic));
        System.out.println(result);
    }
    public static  String breakWord(char[] str, int low, Set<String> dictionary){

        StringBuilder buff = new StringBuilder();
        for(int i=low; i < str.length; i++){
            buff.append(str[i]);
            if(dictionary.contains(buff.toString())){
               String result = breakWord(str, i+1, dictionary);
                System.out.println(result);
               if(result != null){
                   return buff.toString()+" "+result;
               }
            }
        }
        if(dictionary.contains(buff.toString())){
            return buff.toString();
        }
        return null;
    }

    public static  String breakWordDP(String word, Set<String> dict){
        int T[][] = new int[word.length()][word.length()];

        for(int i=0; i < T.length; i++){
            for(int j=0; j< T[i].length; j++){
                T[i][j] = -1;
            }
        }
        for(int l=1; l <= word.length(); l++){
            for (int i=0; i < word.length()-l +1; i++){
                int j= i+l-1;
                String str = word.substring(i, j+1);
                if(dict.contains(str)){
                    T[i][j] = i;
                    continue;
                }
                for(int k=i+1; k <=j; k++){
                    if(T[i][k-1] != -1 && T[k][j] != -1){
                        T[i][j] = k;
                        break;
                    }
                }
            }
        }

        if(T[0][word.length()-1] == -1){
            return null;
        }
        StringBuilder buffer = new StringBuilder();
        int i = 0; int j = word.length()-1;
        while(i < j){
            int k =T[i][j];
            if(i == k){
                buffer.append(word.substring(i, j+1));
                break;
            }
            buffer.append(word.substring(i,k) +" ");
            i=k;
        }
        return buffer.toString();
    }

    public static List<String>  wordBreakTopDown(String s, Set<String> dict){
        Map<Integer, List<String>> dp = new HashMap<>();
        int max =0;
        for(String s1: dict){
            max = Math.max(max, s1.length());
        }
     return wordBreakUtil(s, dict, dp, 0, max);
    }

    private static List<String> wordBreakUtil(String s, Set<String> dict, Map<Integer, List<String>> dp, int start, int max){

        if(start == s.length()){
            return Collections.singletonList("");
        }
        if(dp.containsKey(start)){
            return dp.get(start);
        }
        List<String> words = new ArrayList<>();
        for(int i = start; i < start+max && i < s.length(); i++){
            String newWord = s.substring(start, i+1);
            if(!dict.contains(newWord)) continue;

            List<String> result = wordBreakUtil(s, dict, dp, i+1, max);
            for(String word: result){
                words.add(newWord +" "+ word);
            }
        }
        dp.put(start, words);
        return  words;
    }


}

package com.interview.dp;

import java.util.*;

public class PalindromePartition {

    static void main() {
        String str = "dbdcbc";
       int min = minCut(str);
        System.out.println(min);
        List<List<String>> result = partition(str);
        System.out.println(result);
    }
    public static int minCut(String str){
        if(str.length() == 0){
            return 0;
        }
        int[] cut = new int[str.length()];
        boolean isPal[][] = new boolean[str.length()][str.length()];
        for(int i=1; i < str.length(); i++){
            int min = i;
            for(int j=0; j <=i; j++){
                if(str.charAt(i) == str.charAt(j) && (
                        i <= j+1 || isPal[i-1][j+1]
                        )){
                    isPal[i][j] = true;
                    min = Math.min(min, j==0?0 : 1+cut[j-1]);
                }
            }
            cut[i] = min;
        }
        return cut[str.length()-1];
    }

    public static List<List<String>> partition(String s){
        Map<Integer, List<List<String>>> dp = new HashMap<>();
        List<List<String>> result = partitionUtil(s, dp, 0);
        return result;

    }

    private static List<List<String>> partitionUtil(String s, Map<Integer, List<List<String>>> dp, int startIndex) {

        if(startIndex == s.length()){
            List<String> r = new ArrayList<>();
            return Collections.singletonList(r);
        }

        if(dp.containsKey(startIndex)){
            return dp.get(startIndex);
        }
        List<List<String>> words = new ArrayList<>();
        for(int i = startIndex; i < s.length(); i++ ){
            if(!isPalindrop(s, startIndex, i)){
                continue;
            }
            String newWord = s.substring(startIndex, i+1);
            List<List<String>> result = partitionUtil(s, dp, i + 1);
            for(List l : result){
                List<String> lst = new ArrayList<>();
                lst.add(newWord);
                lst.addAll(l);
                words.add(lst);
            }
        }
        dp.put(startIndex, words);
        return words;
    }

    private static boolean isPalindrop(String str, int startIndex, int endIndex) {
      while(startIndex < endIndex){
          if(str.charAt(startIndex) != str.charAt(endIndex)){
              return false;
          }
          startIndex++;
          endIndex--;
      }
      return true;
    }
}

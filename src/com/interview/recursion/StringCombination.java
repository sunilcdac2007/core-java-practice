package com.interview.recursion;

import com.interview.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringCombination {

    static void main() {
        String text = "aabbcc";
       // combinationRecursion(text);
      StringCombination com = new StringCombination();
        com.combination(text.toCharArray());
    }

    public void combination(char arr[]){
        Map<Character, Integer> countMap = new TreeMap<>();
        for(char ch: arr){
            countMap.compute( ch, (key,val) -> val == null ? 1:  val+1);
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for(Map.Entry<Character, Integer> entry: countMap.entrySet()){
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
      char[] output = new char[arr.length];
        comination(str, count, 0, output, 0);
    }

    private void comination(char[] str, int[] count, int pos, char[] output, int len) {

        for(int i=0; i< len; i++){
            System.out.print(output[i] +" ");
        }
        System.out.println();
        for(int i=pos; i < str.length; i++){
            if(count[i] == 0) continue;

            output[len] = str[i];
            count[i]--;
            comination(str, count, i, output, len+1);
            count[i]++; // backtracking
        }
    }

    private static void combinationRecursion(String text) {
        List<Character> result = new ArrayList<>();
        cominationUtil(text.toCharArray(), result, 0);
    }

    private static void cominationUtil(char[] text, List<Character> result, int pos) {
      result.forEach(System.out::print);
        System.out.println("\n");
      for(int i=pos ; i < text.length; i++){
          if(i != pos && text[i] == text[i-1]) continue;
          result.add(text[i]);
          cominationUtil(text, result, i+1);
          result.remove(result.size()-1);// backtracking
      }

    }
}

package com.interview.string;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class AnagramOfFirstAsSubstring {

    // str1 = "wuabcd"
    // str2 = "cdbaxuzabcuvw"

    static void main() {
        String str1 = "wuabcd";
        String str2 = "cdbaxuzabcuvw" ;
        AnagramOfFirstAsSubstring anagram = new AnagramOfFirstAsSubstring();
       boolean res =  anagram.isSubString(str1.toCharArray(), str2.toCharArray());
        System.out.println(res);

    }

    public boolean isSubString(char str1[], char[] str2){

        int index =0;
        int curLen = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> currentCountMap = new HashMap<>();
        Map<Character, Integer> posMap = new HashMap<>();
        IntStream.range(0, str1.length)
                .mapToObj(i -> str1[i])
                .forEach((ch) ->countMap.compute( ch,  (k,v) -> (v == null ? 1: v +1)));

        System.out.println(countMap);
        while( index < str2.length){
            if(continsAndUpdate(currentCountMap, countMap, str2[index], posMap, index)){
                index++;
                curLen++;
            } else{
                Integer p = posMap.get( str2[index]);
                if(p != null){
                    curLen = index -p;
                    index = p;
                } else {
                    index++;
                }
                currentCountMap.clear();
                posMap.clear();
            }
            if(curLen == str1.length){
                return true;
            }
        }
        return false;
    }

    private boolean continsAndUpdate(Map<Character, Integer> currentMap,Map<Character, Integer> countMap,
                                     Character ch, Map<Character, Integer> posMap, int index ){

        if(countMap.containsKey(ch)){
            if(currentMap.containsKey(ch)){
                if(currentMap.get(ch) < countMap.get(ch)){
                    if(currentMap.get(ch) == 1){
                        posMap.put(ch, index);
                    }
                    currentMap.put(ch, currentMap.get(ch) + 1);
                    return true;
                }
            } else {
                currentMap.put(ch, 1);
                posMap.put(ch, index);
                return true;
            }
        }
        return false;
    }
}

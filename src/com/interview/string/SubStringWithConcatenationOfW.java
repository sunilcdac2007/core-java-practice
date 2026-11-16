package com.interview.string;

import java.util.*;

public class SubStringWithConcatenationOfW {

    private void updateMap(Map<String , Integer> cache, String[] words){
      Arrays.stream(words).forEach( word -> {
          cache.compute(word, (key,value) -> value == null ? 1: value+1);
      });
    }


    public List<Integer> findSubString(String str, String[] words){

        Map<String , Integer> acutal = new HashMap<>();
        Map<String, Integer> used = new HashMap<>();
        updateMap(acutal, words);

        List<Integer> output = new ArrayList<>();
        int len = words[0].length();
        int count = words.length;
        int k = words.length*len;
        for(int i =0; i <= str.length()-k; i++){
            int j =i;
            int currentCount =0;
            while(true){

                if(j + len > str.length()){
                    break;
                }

                String sub = str.substring(j, j+len);
                Integer acutalCount = acutal.get(sub);
                if( acutalCount != null ){


                    Integer usedCount = used.get(sub);
                    if(usedCount == null){
                        usedCount = 0;
                    }
                    if(acutalCount > usedCount){
                        j = j + len;
                        currentCount++;
                        used.put(sub, usedCount+1);
                    } else {
                        break;
                    }
                } else {
                    break;
                }

                if(currentCount == count){
                    break;
                }
            }
            used.clear();
            if(currentCount == count){
                output.add(i);
            }
        }
        return output;
    }

    static void main() {
        String str = "barfoo thefoobarman";
        String words[] = {"foo", "bar"};
        SubStringWithConcatenationOfW con = new SubStringWithConcatenationOfW();
        List<Integer> lst = con.findSubString(str, words);
        System.out.println(lst);
    }


}

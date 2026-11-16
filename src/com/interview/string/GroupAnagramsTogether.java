package com.interview.string;

import java.util.*;

public class GroupAnagramsTogether {

    public  List<List<String>> groupAnagrams(String[] arr){

        if(arr == null || arr.length ==0) {
            return Collections.EMPTY_LIST;
        }
        int index =0;
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> anagramGroup = new HashMap<>();

        for(String str: arr){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr =  new String(chars);
            if(anagramGroup.containsKey(sortedStr)){
                int listIndex = anagramGroup.get(sortedStr);
                List<String> listResult = result.get(listIndex);
                listResult.add(str);
            } else {
                List<String> listResult = new ArrayList<>();
                listResult.add(str);
                result.add(index, listResult);
                anagramGroup.put(sortedStr, index);
                index++;
            }
        }
        return result;
    }

    static void main() {
        GroupAnagramsTogether ana = new GroupAnagramsTogether();
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lst = ana.groupAnagrams(arr);

        System.out.println(lst);
    }
}

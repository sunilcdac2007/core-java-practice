package com.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class ChainingWord {

    static void main() {
        String arr[] = {"gik","geeks","seeks","sing","king"};
        //"gik" --> king --> geeks--> seeks --> sing

        boolean isChaining = isChainingArray(arr);
        System.out.println(isChaining);
    }

    private static boolean isChainingArray(String[] arr) {

        boolean[] used = new boolean[arr.length];
        List<String> result = new ArrayList<>();
        String firstSTr = arr[0];
        result.add(firstSTr);
        used[0]= true;
       boolean r =  findChaining(arr, used, result,firstSTr.charAt(0));
        return r;
    }

    private static boolean findChaining(String[] arr, boolean[] used, List<String> result, char firstCharOfStr) {

        if(result.size() == arr.length){
            // recursion termination condition
            String lastWordOfRes= result.get(result.size()-1);
            if(lastWordOfRes.charAt(lastWordOfRes.length()-1) == firstCharOfStr){
                result.forEach(System.out::println);
                return true;
            }
            return false;
        }

        String lastWord = result.get(result.size()-1);
        for(int i=0;i < arr.length; i++){

            if(used[i]) continue;

            char lastChar = lastWord.charAt(lastWord.length()-1);
            if(lastChar == arr[i].charAt(0)){
                used[i] = true;
                result.add(arr[i]);
                boolean isChainExist = findChaining(arr, used, result, firstCharOfStr);
                if(isChainExist) return true;
                used[i]= false;
                result.remove(result.size()-1);
            }
        }
    return false;
    }
}

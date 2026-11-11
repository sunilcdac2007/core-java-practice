package com.interview.recursion;

import java.util.Arrays;
import java.util.List;

public class WordCombination {

    static void main() {
        /*
        {"hello" , "world"}
        {"game"}
        {"go", "home"}
        * */

        List<List<String>> words = Arrays.asList(Arrays.asList("hello", "world"),Arrays.asList("game"),Arrays.asList("go" , "home"));
        WordCombination wordCombination = new WordCombination();
        int[] result = new int[words.size()];
        wordCombination.wordCombination(words,result,0);
    }

    public void wordCombination(List<List<String>> words, int[] resultIndex, int pos){

        if(pos == resultIndex.length){
           for( int i=0; i < words.size(); i++){
               System.out.print(words.get(i).get(resultIndex[i]) +" ");
           }
            System.out.println();
            return;
        }

        for( int i=0; i < words.get(pos).size(); i++){

            resultIndex[pos] = i;
            wordCombination(words, resultIndex, pos+1);
        }

    }
}

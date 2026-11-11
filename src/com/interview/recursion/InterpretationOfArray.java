package com.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class InterpretationOfArray {

    static void main() {
        int arr[] = {1,1};
        char[][] interpretArr = new char[arr.length][arr.length];
        interpreate(arr,interpretArr);
    }

    private static void interpreate(int[] arr, char[][] interpretArr) {

        for(int l=1; l <= 2 ; l++){
            for( int i=0; i <= arr.length -l; i++){
                int j = i + l -1;
                char latter = getCharRepresentation( i == j ? arr[i]: arr[i]*10 + arr[j]);
                interpretArr[i][l-1] = latter;
            }
        }

        List<Character> result = new ArrayList<>();

        interpretVal(arr.length, 0, result, interpretArr);

    }

    private static void interpretVal(int len, int pos, List<Character> result, char[][] interpretArr) {
        if(pos == len){
            result.forEach(System.out::print);
            System.out.println();
            return;
        }
        if(interpretArr[pos][0] != 0){
            result.add(interpretArr[pos][0]);
            interpretVal(len, pos+1, result,interpretArr);
            result.remove(result.size()-1);
        }
        if( pos +1 < len && interpretArr[pos][1] != 0){
            result.add(interpretArr[pos][1]);
            interpretVal(len, pos+2, result, interpretArr);
            result.remove(result.size()-1);
        }
    }

    static char getCharRepresentation(int num){

        if(num >26 && num < 0) return 0;

        return (char) ('a' + num -1);
    }

}

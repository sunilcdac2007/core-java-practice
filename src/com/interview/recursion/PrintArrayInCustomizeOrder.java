package com.interview.recursion;

import java.util.HashMap;
import java.util.Map;

public class PrintArrayInCustomizeOrder {

    static void main() {
        char arr[][] = {
                {'a','b'},
                {'a','c'},
                {'b','d'},
                {'c','f'},
                {'b','e'},
                {'x','y'},
                {'y','z'}
        };

     customizePrint(arr);
    }

    private static void customizePrint(char[][] arr) {

        Map<Character, Boolean> visited = new HashMap<>();
        Map<Character, Boolean> printed = new HashMap<>();

        for(int i=0; i< arr.length; i++){
            if(!visited.containsKey(arr[i][0])){
                if(!printed.containsKey(arr[i][0])){

                    printed.put(arr[i][0], true);
                    System.out.print(arr[i][0]);
                    System.out.println("\n");
                }
                searchNextLink(arr, i, 5, visited);
            }
        }
    }

    private static void searchNextLink(char[][] arr, int pos, int distance, Map<Character, Boolean> visited) {
        for(int i=0; i< distance; i++){
            System.out.print("->");
        }
        char ch = arr[pos][1];
        System.out.println(ch);
        visited.put(ch, true);
        for ( int i=pos+1; i < arr.length; i++){
            if(ch == arr[i][0] && i != arr.length){
                searchNextLink(arr, i, distance+5, visited);
            }
        }
    }

}

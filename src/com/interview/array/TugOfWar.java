package com.interview.array;

import java.util.ArrayList;
import java.util.List;

public class TugOfWar {

    private static int minFoundSoFar = Integer.MAX_VALUE;

    public static void findMin(int arr[]){
        int total = 0;
        for( int i=0; i < arr.length; i++){
            total = total + arr[i];
        }
        List<Integer> result = new ArrayList<>();
        combinationUtil(arr, arr.length/2, 0, 0, total, 0, result);
    }

    private static void combinationUtil(int[] arr, int k, int startIndex, int sum, int total, int pos, List<Integer> result) {

        if(pos == k){
            if(Math.abs(sum - total/2) < minFoundSoFar){
                minFoundSoFar = Math.abs(sum - total/2);
                System.out.println(" minimum so far "+minFoundSoFar);
            }
            return;
        }
        for( int i = startIndex; i < arr.length; i++){
            sum = sum + arr[i];
            result.add(arr[i]);
            combinationUtil(arr, k, i+1, sum, total, pos+1, result);
            result.remove(result.size()-1);
            sum = sum - arr[i];
        }
    }

    static void main() {
    int arr[] = {23,45,34,14,11,98,99,4,189,1,7,19};

    findMin(arr);
    System.out.println(minFoundSoFar);
    }
}

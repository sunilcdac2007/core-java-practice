package com.interview.recursion;

import java.util.Arrays;

public class CombinationWithK {

    static void main() {
        int arr[] = {1,2,3,4};
        combination(arr,2);
    }

    private static void combination(int[] arr, int k) {

      int[] result = new int[k];
      int resultIndex =0;
      int arrayIndex = 0;

      combinationUtilWithSizeK(arr, result, k, resultIndex, arrayIndex);
    }

    private static void combinationUtilWithSizeK(int[] arr, int[] result, int k, int resultIndex, int arrayIndex) {
     if(resultIndex == k){
         Arrays.stream(result).forEach(System.out::print);
         System.out.println();
         return;
     }

     for(int i= arrayIndex; i < arr.length; i++){
         result[resultIndex] = arr[i];
         combinationUtilWithSizeK(arr,result, k, resultIndex+1, arrayIndex+1);
     }

    }
}

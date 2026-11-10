package com.interview.array;

public class MaximumSumPathTwoArrays {

 // arr1 = [2,3,7,10,12,15,30,34]
 // arr2 = [1,5,7,8,10,15,16,19]


    public static int maxSumPath(int[] arr1, int[] arr2){

        int maxSum = 0;
        int i=0, j=0, sum1 =0, sum2 =0;

        while( i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                if(sum1 > sum2){
                    maxSum = maxSum + sum1 + arr1[i];
                } else {
                    maxSum = maxSum + sum2 + arr2[j];
                }
                i++; j++; sum1 = 0; sum2 = 0;
            } else if(arr1[i] < arr2[j]){

                sum1 = sum1 + arr1[i++];

            } else {
                sum2 = sum2 + arr2[j++];
            }
        }

        while(i < arr1.length){
            sum1 = sum1 = arr1[i++];
        }

        while(j < arr2.length){
            sum2 = sum2 = arr2[j++];
        }
        if(sum1 > sum2){
            maxSum = maxSum + sum1;
        } else {
            maxSum = maxSum + sum2;
        }

        return maxSum;
    }

    static void main() {
        int[] arr1 = {2,3,7,10,12,15,30,34};
         int[] arr2 = {1,5,7,8,10,15,16,19};
       int max = maxSumPath(arr1, arr2);
        System.out.println(max);
    }
}

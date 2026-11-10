package com.interview.array;

import java.util.Arrays;

public class TripletInArray {

    class Triplet{
        int a;
        int b;
        int c;

        public Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public Triplet findTriplet(int[] arr, int sum){
        Arrays.sort(arr);
        for( int i=0; i < arr.length -2; i++){
            int j = i +1;
            int k = arr.length-1;
            int updatedSum = sum -arr[i];
            while(j < k){
                if( updatedSum == arr[j] + arr[k]){
                    return new Triplet(arr[i], arr[j], arr[k]);
                }
                if( updatedSum > arr[j] + arr[k]){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return null;
    }
}

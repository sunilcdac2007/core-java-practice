package com.interview.array;

import java.util.Arrays;

public class ThreeSumSmallerThanTarget {

    public int threeSumSmaller(int[] arr, int target){
        if( arr.length < 3) return 0;

        Arrays.sort(arr);
        int count = 0;
        for( int i =0; i < arr.length; i++){
            int j = i +1;
            int k = arr.length -1;
            while(j < k){
                if(arr[i] + arr[j] + arr[k] >= target){
                    k--;
                } else {
                    count = count + k -j;
                    j++;
                }
            }
        }
        return count;
    }

}

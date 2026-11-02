package com.interview.dp;

import java.util.HashSet;
import java.util.Set;

public class CheckPairOfTwoNumber {

    static void main() {
        int[] nums = {2,11,5,1,4,2,1};
        System.out.println(checkPairOfNumber(nums));
    }
    static boolean checkPairOfNumber(int[] arr){
        int sum =0;
        for(int num: arr){
            sum = sum + num;
        }
        if(sum%2 != 0) return false;
        sum = sum/2;
        Set<Integer> s = new HashSet<>();
        for(int i=0; i < arr.length; i++){
            int val = sum - arr[i];
            if(s.contains(val)){
                return true;
            }
            s.add(arr[i]);
        }
        return false;
    }
}

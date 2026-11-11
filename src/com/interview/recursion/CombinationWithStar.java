package com.interview.recursion;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CombinationWithStar {

    static void main() {
        int[] nums = {1,2,3,4};
        boolean used[] = new boolean[nums.length];
        combinationWithStart(nums,used, 0);
    }

    private static void combinationWithStart(int[] nums, boolean[] used, int pos) {
     printStar(nums, used);
        System.out.println();
     for(int i=pos; i < nums.length; i++){
         used[i] = true;
         combinationWithStart(nums, used, pos+1);
         used[i] = false;
     }

    }

    private static void printStar(int[] nums, boolean[] used) {
        IntStream.range(0, nums.length)
                .forEach(i ->{
                  if(used[i]){
                      System.out.print(nums[i]);
                  }else {
                      System.out.print("*");
                  }
                });
    }
}

package com.interview.array;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerOnRightSide {

    static class NumberIndex{
        int val;
        int index;
        NumberIndex(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums){

        if(nums.length == 0){
            return new ArrayList<>();
        }

        return null;
    }

}

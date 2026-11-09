package com.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerOnRightSide {

    static void main() {
        int nums[] = {5,2,6,1,0,13};
        CountSmallerOnRightSide smal = new CountSmallerOnRightSide();
      int[] val =  smal.countSmaller(nums);
        Arrays.stream(val).forEach(System.out::println);
    }
    static class NumberIndex{
        int val;
        int index;
        NumberIndex(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    public int[]  countSmaller(int[] nums){

        if(nums.length == 0){
            return null;
        }
     NumberIndex[] arr = new NumberIndex[nums.length];
     for(int i=0; i < nums.length; i++){
         arr[i] = new NumberIndex(nums[i], i);
     }
     int result[] = new int[nums.length];
     mergeUtil(arr, result, 0, arr.length-1);

        System.out.println(result);
        return result;
    }

    private void mergeUtil(NumberIndex[] arr, int[] result, int low, int high) {

        if(low == high){
            return;
        }
        int mid = (low + high)/2;
        mergeUtil(arr, result, low,mid);
        mergeUtil(arr, result, mid+1, high);
        int i = low;
        int j = mid +1;
        NumberIndex[] temp = new NumberIndex[high-low + 1];
        int k =0;
        int tempResult[] = new int[high-low+1];
        while(i <=mid && j <=high){
            if(arr[i].val <= arr[j].val){
                tempResult[arr[i].index - low] = j-mid-1;
                temp[k++] = arr[i++];
            } else {
                tempResult[arr[i].index - low ] = j-mid;
                temp[k++] = arr[j++];
            }
        }
        int i1 = i;
        while(i1 <= mid){
            tempResult[arr[i1].index-low] = j - mid -1;
            temp[k++] = arr[i1++];
        }

        while(j <= high){
            temp[k++] = arr[j++];
        }
        k=0;
        for(i=low; i <= high; i++){
            arr[i] = temp[k];
            result[i] = result[i] + tempResult[k++];
        }
    }

}

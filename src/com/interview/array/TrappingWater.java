package com.interview.array;

public class TrappingWater {

    public int trap(int[] arr){
        if(arr==null || arr.length ==0) return 0;

        int len = arr.length;
        int[] left = new int[len];
        int right[] = new int[len];
        left[0] = arr[0];
        right[len-1] = arr[len-1];
        for( int i =1; i < len; i++){
            left[i] = Math.max(arr[i], left[i-1]);
            right[len-i-1] = Math.max(arr[len-i -1], right[len-i]);
        }
        int maxWaterTrapped = 0;
        for( int i =1; i < len -1; i++){
            int min = Math.min(left[i], right[i]);
            if(arr[i] < min){
                maxWaterTrapped = maxWaterTrapped + min - arr[i];
            }
        }
        return maxWaterTrapped;
    }

    static void main() {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};

        TrappingWater trap = new TrappingWater();
        int maxWater = trap.trap(arr);
        System.out.println(maxWater);
    }
}

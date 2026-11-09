package com.interview.array;

public class MaximumGap {

    class Bucket{

        int low ;
        int high;
        boolean isSet = false;
        void update(int val){
            if(!isSet){
                low=val;
                high=val;
                isSet=true;
            } else {
                low = Math.min(low,val);
                high = Math.max(high, val);
            }
        }
    }


    public int maximumGap(int[] arr){
        if(arr == null || arr.length <2){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for( int i =0; i< arr.length; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int gap =(int)Math.ceil(
                (double)(max - min)/(arr.length - 1));

        Bucket[] buckets = new Bucket[arr.length -1];
        for( int i=0; i < arr.length; i++){
            buckets[i] = new Bucket();
        }
        for(int i=0; i < arr.length; i++){
            if(arr[i] == max || arr[i] == min){
                continue;
            }
            buckets[(arr[i] - min)/gap].update(arr[i]);
        }

        int prev = min;
        int maxGap =0;
        for ( int i=0; i< buckets.length; i++){
            if(!buckets[i].isSet){
                continue;
            }
            maxGap = Math.max(maxGap, buckets[i].low - prev);
            prev = buckets[i].high;
        }

        return Math.max(maxGap, max - prev);
    }
}

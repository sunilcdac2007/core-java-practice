package com.interview.array;

public class SmallestPatch {

    public int findPatch(int arr[]){
        int result =1;
        for(int i=0; i < arr.length; i++){
            if (arr[i] <= result){
                result = result + arr[i];
            }else {
                break;
            }
        }
        return result;
    }

    public int minPatch(int[] arr, int n){

        int patch = 0;
        long t = 1;
        int i = 0;
        while( t <= n ){
            if(i == arr.length || t < arr[i]){
                patch++;
                t = t+t;
            }else {
                t = arr[i] + t;
                i++;
            }
        }
        return patch;
    }

}

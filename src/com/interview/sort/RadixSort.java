package com.interview.sort;

public class RadixSort {

    public void radisSort(int arr[]){
        int max = maxNumInArray(arr);
        for(int ex= 1; ex <=max; ex= ex*10){
            countSort(arr, ex);
        }
    }

    private void countSort(int[] arr, int ex) {

        int[] count = new int[10];
        int[] output = new int[arr.length];
     // count arr
        for(int i=0; i < arr.length; i++){
            count[(arr[i]/ex)%10]++;
        }
// prefix sum
        for(int i=1; i < count.length; i++){
            count[i] = count[i] + count[i-1];
        }
// build output array
        for(int i=arr.length-1; i>=0; i--){
            output[count[(arr[i]/ex)%10] -1]=arr[i];
            count[(arr[i]/ex)%10]--;
        }

        for(int i =0; i < arr.length; i++){
            arr[i] = output[i];
        }
    }

    private int maxNumInArray(int[] arr) {

        int max =0;
        for(int num: arr){
            if(max< num){
                max = num;
            }
        }
        return max;
    }


    static void main() {

        int[] arr = {101,10,11,66,94,26,125};
        RadixSort radix = new RadixSort();
        radix.radisSort(arr);
        System.out.println(arr);
    }
}

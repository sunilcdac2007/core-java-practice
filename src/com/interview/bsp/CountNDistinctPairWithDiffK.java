package com.interview.bsp;

public class CountNDistinctPairWithDiffK {

    // arr[] = { 1,2,3,4,5,7,8,11};

    boolean search(int[] arr, int start, int end, int num){
        if(start > end) return false;
        int mid = (start + end)/2;
        while(start < end){

            if(arr[mid] == num){
                return true;
            } else if ( arr[mid] < num){
                return search(arr, mid+1, end, num);
            } else {
                return search(arr, start, mid-1, num);
            }
        }
        return false;
    }

    int countMatchPair(int arr[], int k){
        int count = 0;

        for(int i=0; i< arr.length; i++){

            boolean isMatch = search(arr, i, arr.length-1, arr[i] + k);
            if(isMatch){
                count++;
            }
        }
        return count;
    }

    static void main() {
        CountNDistinctPairWithDiffK diff = new CountNDistinctPairWithDiffK();
        int arr[] = { 1,2,3,4,5,7,8,11};
        System.out.println(diff.countMatchPair(arr, 3));
    }





}

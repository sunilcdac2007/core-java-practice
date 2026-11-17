package com.interview.bsp;

public class CircularBinarySearch {

    // arr[] = {7,10,15,19,3,5,6}

    public int searchLow( int[] arr){

        int low = 0, high = arr.length-1;
        int mid = (low + high)/2;
        while(low < high){

            if( (low == mid || arr[mid] < arr[mid+1]) && ( arr[mid] > arr[mid-1]) ){
                return arr[mid];
            }

            if(arr[mid] > arr[low] && arr[mid] > arr[high]){

               if(arr[low] < arr[high]){
                   high = mid-1;
               }else {
                   low = mid+1;
               }
            } else {
                if(arr[mid-1] < arr[mid+1]){
                    high = mid-1;
                } else {
                    low = mid +1;
                }
            }

        }
        return arr[low];
    }

    static void main() {
        int arr[] = {7,10,15,19,3,5,6};

        CircularBinarySearch cbs = new CircularBinarySearch();
        System.out.println(cbs.searchLow(arr));
    }

}

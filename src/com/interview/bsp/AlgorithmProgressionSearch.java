package com.interview.bsp;

public class AlgorithmProgressionSearch {

    // arr = {2,4,8,10,12,14};

    public int search(int arr[]){
        int low = 0;
        int high = arr.length-1;
        int ap = (arr[high] - arr[low])/ arr.length;

        while(low < high){
            int mid = (high + low)/2;
            if(arr[mid] == arr[0] + ap * mid){
                low = mid +1;
            } else if ( (arr[mid] > arr[0] + ap * mid) &&
                    ( arr[mid-1] == arr[0] + ap * (mid-1)) ){
                return arr[0] + ap * mid;
            } else {
                high= mid-1;
            }

        }
        return -1;
    }

    static void main() {
       int[] arr = {2,4,8,10,12,14};
       AlgorithmProgressionSearch ap = new AlgorithmProgressionSearch();
        System.out.println(ap.search(arr));
    }

}

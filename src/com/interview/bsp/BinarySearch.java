package com.interview.bsp;

public class BinarySearch {

    public int search(int arr[], int num){
        int low = 0, high= arr.length-1;
        while(low< high){
            int mid = (low+high)/2;
            if(arr[mid] == num){
                return mid;
            } else if (arr[mid] > num){
                high = mid-1;
            } else {
                low = mid +1;
            }
        }
        return -1;
    }

    static void main() {
        int[] arr = {1,2,4,5,7,9,14};

        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(arr, 9));
    }
}

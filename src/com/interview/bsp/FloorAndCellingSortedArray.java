package com.interview.bsp;

public class FloorAndCellingSortedArray {
    // arr[] = {1,2,8,10,11,13,19} num = 5
    public int floor(int arr[], int num){

        int low =0;
        int high = arr.length -1;
        while( low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == num || (arr[mid] < num  && (mid == arr.length-1 || arr[mid+1] > num) ) ){
                return mid;
            } else if (arr[mid] < num){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    public int ceiling(int arr[], int num){
        int low =0;
        int high = arr.length -1;
        while( low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == num || (arr[mid] > num  && (mid == 0 || arr[mid-1] < num) ) ){
                return mid;
            } else if (arr[mid] < num){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    static void main() {
        int arr[] = {1,2,8,10,11,13,19} ;
       int x=010;
        System.out.println(x);
        int num = 5;
        FloorAndCellingSortedArray fl = new FloorAndCellingSortedArray();

        System.out.println(fl.floor(arr, num));
        System.out.println(fl.ceiling(arr,num));
    }
}

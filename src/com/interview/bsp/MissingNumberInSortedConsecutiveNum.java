package com.interview.bsp;

public class MissingNumberInSortedConsecutiveNum {

    public static  int findMissing(int arr[]){
        int lowNum = arr[0];
        int low = 0;
        int high = arr.length-1;
        int mid = (low + high)/2;
        while ( low <= high){
            mid = (low + high)/2;

            if( (arr[mid] ==  mid +1 + lowNum) && mid-1 >= 0 && (arr[mid-1] == mid + lowNum -1)){
                return mid + lowNum;
            } else if ( mid + lowNum == arr[mid]){
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return Integer.MIN_VALUE;
    }

    static void main() {
        int arr [] = { -5,-4,-3,-1,0,1,2,3,4,5};
        System.out.println(findMissing(arr));
    }

}

package com.interview.bsp;

public class MedianOfTwoSortedArray {

    public double median(int[] arr1, int[] arr2) {
        int low1 = 0;
        int high1 = arr1.length-1;

        int low2 = 0;
        int high2 = arr1.length-1;

        while (true) {

            if (high1 == low1) {
                return (double) ((arr1[low1] + arr2[low2]) / 2);
            }
            if (high1 - low1 == 1) {
                return (double) (Math.max(arr1[low1], arr2[low2]) + Math.min(arr1[high1], arr2[high2])) / 2;
            }

            double med1 = getMedian(arr1, low1, high1);
            double med2 = getMedian(arr2, low2, high2);
            if(med1 <= med2){
                if( (high1 - low1 +1)%2 == 0){
                    low1 = (high1 + low1)/2;
                    high2 = (high2 + low2)/2 + 1;
                } else {
                    low1 = (high1 + low1)/2;
                    high2 = (high2 + low2)/2 ;
                }
            } else {
                if( (high1 - low1 +1)%2 == 0){
                    high1 = (high1 + low1)/2 +1 ;
                    low2 = (high2 + low2)/2 ;
                } else {
                    high1 = (high1 + low1)/2  ;
                    low2 = (high2 + low2)/2 ;
                }
            }

        }

    }

    private double getMedian(int[] arr, int low, int high) {

        int len = high - low + 1;
        int mid = (low + high) / 2;
        if (len % 2 == 0) return (arr[mid] + arr[mid - 1]) / 2;
        else return arr[mid];
    }

    static void main() {
        int arr1[] = { 1,2,3,4,5,6,7};
        int arr2[] = {-1,7,8,12,18,19,22};

        MedianOfTwoSortedArray medi = new MedianOfTwoSortedArray();
        System.out.println(medi.median(arr1, arr2));

    }
}

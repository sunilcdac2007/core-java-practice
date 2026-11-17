package com.interview.sort;

public class MergeSort {

    public void sort(int arr[]){
        sort(arr, 0, arr.length-1);
    }

    private void sort(int[] arr, int start, int end) {

        if(start >= end) return;

        int middle = (start + end)/2;

        sort(arr, start, middle);
        sort(arr,middle+1, end);
        sortedMerge(arr, start,end);
    }

    private void sortedMerge(int[] arr, int start, int end) {
       int middle = (start + end)/2;
       int temp[] = new int[ end - start + 1];
       int i = start;
       int j = middle + 1;
       int r = 0;
       while(i <= middle && j <= end){
           if(arr[i] <= arr[j]){
               temp[r++]= arr[i++];
           }else {
               temp[r++] = arr[j++];
           }
       }
       while(i <= middle){
           temp[r++] = arr[i++];
       }
       while(j <= end){
           temp[r++] = arr[j++];
       }
       i = start;
       for(int k=0; k< temp.length;){
           arr[i++]=temp[k++];
       }

    }

    static void main() {
int arr[] = {6,-1,10,4,11,19,12,18,14};
MergeSort merg = new MergeSort();
merg.sort(arr);
        System.out.println(arr);
    }
}

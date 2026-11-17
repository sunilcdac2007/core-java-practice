package com.interview.sort;

public class CountSort {

    public void sort(int arr[]){

        int max = 0;
        for(int num: arr){
            if(max < num)
                max=num;
        }
        int count[] = new int[max];

        for(int i=0; i< arr.length; i++){
            count[arr[i]]++;
        }

        int c=0;
        for(int i=0; i < max; i++){
            while(count[i] > 0){
                arr[c++]= i;
                count[i]--;
            }
        }
    }

    static void main() {
        int arr[] = {6,1,6,7,3,1};
        CountSort count = new CountSort();
        count.sort(arr);
    }


}

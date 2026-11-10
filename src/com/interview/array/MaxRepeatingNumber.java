package com.interview.array;

public class MaxRepeatingNumber {

    static void main() {
        int[] arr = {0,1,2,1,1,1};
        MaxRepeatingNumber rep = new MaxRepeatingNumber();
        rep.max(arr, 3);
    }
    public int max(int arr[], int k){
        for(int i =0; i < arr.length; i++){
            arr[arr[i]%k]  += k;
        }
        int maxRepeating = 0;
        int maxRepeatingIndex = 0;
        for( int i=0; i< k; i++){
            if(maxRepeating <arr[i]){
                maxRepeating = arr[i];
                maxRepeatingIndex = i;
            }
        }
        for( int i=0; i < k ; i++){
            arr[i] = arr[i] % k;
        }
         return maxRepeatingIndex;
    }
}

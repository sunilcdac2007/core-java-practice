package com.interview.array;

public class MoveAllZeroAtEnd {

    // arr = [0,0,1,2,0,5,6,7,0]
    public void moveZero(int[] arr){
        int slowIndex =0;
        int fastIndex = 0;

        for(int i=0; i < arr.length; i++){
            if(arr[fastIndex] == 0){
                fastIndex++;
                continue;
            }
            arr[slowIndex++] = arr[fastIndex++];
        }
        while(slowIndex < arr.length){
            arr[slowIndex++] = 0;
        }
    }
}

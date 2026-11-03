package com.interview.dp;

public class MinJump {

    // [2,3,1,1,4]

    static void main() {
        int[] arr= {2,3,1,1,4};

        int val = numOfJumpDP(arr);
        System.out.println(val);
    }

    private static int numOfJumpDP(int[] arr) {
        int[] resultIndex = new int[arr.length];
        int[] jumpCount = new int[arr.length];
        jumpCount[0] = 0;
        for(int i=1; i< arr.length; i++){
            jumpCount[i] = Integer.MAX_VALUE-1;
        }

        for(int i=1; i< arr.length; i++){
            for(int j =0; j<i; j++){
                if(arr[j] + j >= i){
                    if(jumpCount[i] > jumpCount[j] +1){
                        jumpCount[i] = jumpCount[j] +1 ;
                        resultIndex[i] = j;
                    }
                }
            }
        }

     return jumpCount[arr.length-1];
    }

}

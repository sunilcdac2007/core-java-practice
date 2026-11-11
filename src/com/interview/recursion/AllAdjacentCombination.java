package com.interview.recursion;

public class AllAdjacentCombination {

    static void main() {
        int arr[] = {1,2,3,4};

        AllAdjacentCombination com = new AllAdjacentCombination();
        int[] result = new int[arr.length];
        com.combination(arr, result,2, 0, 0);
    }
    public void combination(int[] arr, int[] result, int k, int pos, int rIndex){

        if(pos == arr.length){
            for( int i=0; i < rIndex; i++){
                System.out.print(result[i] +" ");
            }
            System.out.println();
        }

        for( int i=pos; i < pos + k && i < arr.length; i++){
            result[rIndex] = formNumber(arr, pos, i);
            combination(arr, result, k, i+1, rIndex+1);
        }
    }

    private int formNumber(int[] arr, int start, int end) {

    int num =0;
    for( int i = start; i <= end; i++ ){
        num = num * 10 + arr[i];
    }
    return num;
    }

}

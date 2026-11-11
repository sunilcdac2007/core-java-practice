package com.interview.recursion;

import java.util.Arrays;

public class PrintPathFromTopToBottom {

    static void main() {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int result[] = new int[arr.length + arr[0].length-1];
        int pos = 0;
        printAllPath(arr, result, pos, 0, 0);
    }

    private static void printAllPath(int[][] arr, int[] result, int pos, int row, int col) {

        if(row == arr.length-1 && col == arr[0].length-1){
            // termination condition
            result[pos] = arr[row][col];
            Arrays.stream(result).forEach(System.out::print);
            System.out.println();
            return;
        }
        if(row >= arr.length || col >= arr[0].length){ return;}

        result[pos] = arr[row][col];
        printAllPath(arr, result, pos+1, row+1, col);
        printAllPath(arr, result, pos+1, row, col+1);
    }
}

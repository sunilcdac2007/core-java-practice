package com.interview.multiarray;

public class LongestConsecutiveNumberInUnsortedArr {

    public int longest(int[][] arr){
        int max = 1;

        boolean[][] visitedArr = new boolean[arr.length][arr[0].length];
        for(int i=0; i < arr.length; i++){
            for(int j=0; j < arr[i].length; j++){
                int tempMax =  DFS(arr, i, j, visitedArr, Integer.MIN_VALUE);
            }
        }

        return max;
    }

    private int DFS(int[][] arr, int rowIndex, int colIndex, boolean[][] visitedArr, int previousVal) {

        if(rowIndex >= arr.length || rowIndex < 0 || colIndex < 0 || colIndex > arr[0].length){
            return 0;
        }

        if(visitedArr[rowIndex][colIndex]) return 0;
        if(previousVal != Integer.MIN_VALUE && arr[rowIndex][colIndex] +1 != previousVal){
            return 0;
        }
        visitedArr[rowIndex][colIndex] = true;
        int r1 = DFS(arr, rowIndex+1, colIndex, visitedArr, arr[rowIndex][colIndex]);
        int r2 = DFS(arr, rowIndex-1, colIndex, visitedArr, arr[rowIndex][colIndex]);
        int r3 = DFS(arr, rowIndex, colIndex+1, visitedArr, arr[rowIndex][colIndex]);
        int r4 = DFS(arr, rowIndex, colIndex-1, visitedArr, arr[rowIndex][colIndex]);
        visitedArr[rowIndex][colIndex] = false;
        return Math.max(Math.max(r1,r2), Math.max(r3,r4));
    }

}

package com.interview.dp;

public class LongestIncreastingPath {

    private int longPathInMatrix(int[][] matrix){
        if(matrix.length ==0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int maxPath = 1;
        int[][] distanceMatrix = new int[row][col];
        for(int i=0; i< row; i++){
            for(int j=0; j<col; j++){
                int res = searchRec(matrix, i, j, distanceMatrix, Integer.MIN_VALUE);
              if(res > maxPath){
                  maxPath = res;
              }
            }
        }

        return maxPath;
    }

    private int searchRec(int[][] matrix, int row, int col, int[][] distanceMatrix, int previusVal) {

        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length){
            return 0;
        }
        if(matrix[row][col] <= previusVal){
            return 0;
        }
        if(distanceMatrix[row][col] != 0){
            return distanceMatrix[row][col];
        }
        int res1 = searchRec(matrix, row-1, col, distanceMatrix, matrix[row][col]);
        int res2 = searchRec(matrix, row, col-1, distanceMatrix, matrix[row][col]);
        int res3 = searchRec(matrix, row+1, col, distanceMatrix, matrix[row][col]);
        int res4 = searchRec(matrix, row, col+1, distanceMatrix, matrix[row][col]);
        distanceMatrix[row][col] = Math.max(Math.max(res1,res2),Math.max(res3, res4)) +1;
        return distanceMatrix[row][col];
    }

    static void main() {
        int[][] matrix = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };

        LongestIncreastingPath longestIncreastingPath = new LongestIncreastingPath();
       int max = longestIncreastingPath.longPathInMatrix(matrix);
        System.out.println(max);
    }

}

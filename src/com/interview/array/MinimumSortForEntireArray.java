package com.interview.array;

public class MinimumSortForEntireArray {

    public int minLenght(int arr[]){
        int i = 0;
        while(i < arr.length -1 && arr[i] < arr[i+1]){
            i++;
        }

        if(i == arr.length -1) return 0;
        int j = arr.length-1;
        while( j > 0 && arr[j] > arr[j-1]){
            j--;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for( int k = i; k <= j; k++){
            if(max < arr[k]){
                max = arr[k];
            }
            if(min > arr[k]){
                min = arr[k];
            }
        }

        int x = i-1;
        while(x >= 0){
            if(min > arr[x]){
                break;
            }
            x--;
        }

        int y = j + 1;
        while(y < arr.length){
            if(max < arr[y]){
                break;
            }
            y++;
        }

         return y -x -1;

    }
}

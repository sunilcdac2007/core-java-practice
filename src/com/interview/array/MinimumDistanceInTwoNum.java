package com.interview.array;

public class MinimumDistanceInTwoNum {

    public int minDistance(int[] arr, int x, int y){
        int prev = -1;
        int prevFound = -1;
        int min = 10000;
        for(int i=0; i < arr.length; i++){
            if(arr[i] == x){

                if(prevFound == -1){
                    prevFound = x;
                    prev=i;
                }else if( prevFound == x){
                    prev=i;
                } else {
                    min = min > i -prev ? i -prev: min;
                    prev = i;
                    prevFound = x;
                }
            } else if (arr[i] == y){

                if(prevFound == -1){

                    prevFound = y;
                    prev=i;
                } else if (prevFound == y){
                    prev = i;
                }else {
                    min = min > i - prev? i - prev: min;
                    prevFound = y;
                    prev = i;
                }
            }
        }
    return min;
    }

    static void main() {
        MinimumDistanceInTwoNum mn= new MinimumDistanceInTwoNum();
        int[] arr = {6,4,1,5,6,9,10,7,4,4,6,6};
       int dis = mn.minDistance(arr, 5,6);
        System.out.println(dis);
    }
}

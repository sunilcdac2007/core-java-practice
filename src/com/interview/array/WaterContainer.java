package com.interview.array;

public class WaterContainer {

    public int maxArea(int[] arr){
        int i = 0;
        int j = arr.length -1;
        int maxArea = 0;
        while( i < j){
            if( arr[i] < arr[j]){
                maxArea = Math.max(maxArea, arr[i] * (j -i));
                i++;
            } else {
                maxArea = Math.max(maxArea, arr[j] * (j-i));
                j--;
            }
        }
        return maxArea;
    }

    static void main() {
        WaterContainer waterContainer = new WaterContainer();
        int[] arr = {0,4,3,5,3,5,3,6};
        int max = waterContainer.maxArea(arr);
        System.out.println(max);

    }
}

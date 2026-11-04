package com.interview.array;

public class ArrayAddition {
    static void main() {
        int[] arr1= {9,9,9};
        int[] arr2 = {1,6,8};
       int[] addition = add(arr1,arr2);
        System.out.println(addition);
    }

    public static int[] add(int arr1[], int arr2[]){
       int large = Math.max(arr1.length, arr2.length);
       int[] result = new int[large];
       int arr1Index= arr1.length-1;
       int arr2Index = arr2.length-1;
       int resultIndex = result.length-1;

       int carriage =0;
       int remainder = 0;

       while(arr1Index >= 0 && arr2Index >=0){
           remainder = arr1[arr1Index--] + arr2[arr2Index--] + carriage;
           carriage = remainder/10;
           result[resultIndex--] = remainder%10;
       }
       while(arr1Index >=0){
           remainder = arr1[arr1Index--] + carriage;
           carriage = remainder/10;
           result[resultIndex--] = remainder%10;
       }

       while(arr2Index >=0){
           remainder = arr2[arr2Index--] + carriage;
           carriage = remainder/10;
           result[resultIndex--] = remainder%10;
       }

       if(carriage != 0){
        int[] result1 = new int[result.length+1];
        int k = result1.length-1;
        while(k >0){
            result1[k--] = result[k];
        }
           result1[0] = carriage;
        return result1;
       }
   return result;
    }
}

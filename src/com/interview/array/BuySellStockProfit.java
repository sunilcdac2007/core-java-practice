package com.interview.array;

public class BuySellStockProfit {

    // arr = [7,10,15,5,11,2,7,9,3]
    static void main() {
        int arr[] = {7,10,15,5,11,2,7,9,3};
        maxProfitInOneTransaction(arr);
    }
  static  int  maxProfitInOneTransaction(int[] arr){

        int minPrice = arr[0];
        int maxProfit = 0;
        for(int i=1; i < arr.length; i++){
            if(arr[i] - minPrice > maxProfit){
                maxProfit = arr[i] - minPrice;
            }
            if(arr[i] < minPrice){
                minPrice = arr[i];
            }
        }
        return maxProfit;
    }

    public int allTimeProfit(int arr[]){
        if(arr.length == 0) return 0;
        int profit =0;
        int localMin = arr[0];
        for(int i=1; i < arr.length; i++){
            if(arr[i-1] >= arr[i]){
                localMin= arr[i];
            }else {
                profit = profit + arr[i] - localMin;
                localMin = arr[i];
            }
        }
        return profit;
    }
}

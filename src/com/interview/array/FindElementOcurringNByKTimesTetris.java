package com.interview.array;

public class FindElementOcurringNByKTimesTetris {
    public static class Pair{
        public int element;
        public int count;
    }

    public void printElementOccurringKTimes(int[] arr, int k){

        Pair[] p = new Pair[k];
        for ( int i=0; i < k; i++){
            p[i] = new Pair();
        }
        for(int i=0; i < arr.length; i++){
            int j=0;
            for(j = 0; j < k; j++){
                if(p[j].element == arr[i]){
                    p[j].count++;
                    break;
                }
            }
            if(j==k){
                int l = 0;
                for(l = 0; l < k; l++){
                    if(p[l].count == 0){
                        p[l].element = arr[i];
                        p[l].count = 1;
                        break;
                    }
                }
                if(l == k){
                    for( int t = 0; t<k; t++){
                        p[t].count--;
                    }
                }
            }

        }

       for( int i=0; i < k; i++){
           if(p[i].count > 0){
               int count = 0;
               for(int j =0 ; j < arr.length; j++){
                   if(arr[j] == p[i].element){
                       count++;
                   }
               }
               if(count >= arr.length/k){
                   System.out.println(p[i].element);
               }
           }
       }

    }
}

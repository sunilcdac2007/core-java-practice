package com.interview.dp;

public class Fibonaciiseries {

    public int fibonacciseries(int n){
        int n1=0, n2=1;
        int sum;
        if(n == n1 || n == n2){
            return n;
        }
        for(int i=2; i<=n; i++){
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return n2;
    }

    public int fibonacciRec(int num){
        if(num ==1 || num ==0){
            return num;
        }
        return fibonacciRec(num-1) + fibonacciRec(num-2);
    }
}

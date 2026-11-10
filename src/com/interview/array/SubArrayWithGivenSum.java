package com.interview.array;

public class SubArrayWithGivenSum {

    class Pair {
        int start;
        int end;
    }

    public Pair findSubArray(int[] arr, int sum) {
        int currentSum = 0;
        Pair p = new Pair();
        p.start = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            p.end = i;
            if (currentSum == sum) {
                return p;
            } else if (currentSum > sum) {
                int s = p.start;
                while (currentSum > sum) {
                    currentSum = currentSum - arr[s];
                    s++;
                }
                p.start = s;
                if (currentSum == sum) {
                    return p;
                }
            }

        }
        return p;
    }

    static void main() {
        SubArrayWithGivenSum sub = new SubArrayWithGivenSum();
        int[] arr = {6,3,9,11,1,3,5};
        Pair p = sub.findSubArray(arr, 15);
        System.out.println(p.start +" "+ p.end);
    }
}

package com.interview.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LargerElementOnRight {

    public int[] larger(int[] arr){

        Deque<Integer> stack = new LinkedList<>();
        int result[] = new int[arr.length];
        for( int i =0; i < result.length; i++){
            result[i] = -1;
        }
        stack.offerFirst(0);
        for(int i = 1; i <arr.length; i++){
            while(stack.size()>0){
                int t = stack.peekFirst();
                if(arr[t] < arr[i]){
                    result[t] = i;
                    stack.pollFirst();
                } else {
                    break;
                }
            }
            stack.offerFirst(i);
        }
        return result;
    }

    static void main() {
        int[] arr = {4,5,2,25};
        LargerElementOnRight largerElementOnRight = new LargerElementOnRight();
        int[] found = largerElementOnRight.larger(arr);
        Arrays.stream(found).forEach(System.out::println);
    }
}

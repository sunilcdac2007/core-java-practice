package com.interview.recursion;

import java.util.Deque;
import java.util.LinkedList;

public class Bracketology {

    public boolean matchBracket(char[] brackets){
     Deque<Character> stack = new LinkedList<>();

     for(char ch: brackets){
         char checkChar = getOpeningChar(ch);
         if(checkChar == 0){
             stack.add(ch);
         } else {
             if(stack.size() == 0 || stack.peek() != checkChar){
                 return false;
             } else {
                 stack.pop();
             }
         }
     }
     if(stack.size() > 0) return false;
     return true;

    }


    private Character getOpeningChar(char ch){
        switch(ch){
            case ')': return '(';
            case ']': return '[';
            case '}': return '}';
            default: return 0;
        }
    }

    public void bracketPermutation(char[] result, int n, int pos, int openCount, int closeCount){
        if(pos == 2*n){

            for(int i=0; i < result.length; i++){
                System.out.print(result[i] +" ");
            }
            System.out.println();
        }
    }
}

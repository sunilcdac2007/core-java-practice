package com.interview.recursion;

public class StringPermutationRotation {


    public void permute(char[] str, int pos){

        if(pos == str.length){
            for(int i=0; i < str.length;i++){
                System.out.print(str[i]);
            }
            System.out.println();
            return;
        }
        for(int i=pos; i < str.length; i++){
            swap(str, pos,i);
            permute(str, pos+1);
            swap(str,pos,i);
        }

    }

    private void swap(char[] arr, int start, int end) {

        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    static void main() {

        String str = "AABC";
        StringPermutationRotation rot = new StringPermutationRotation();
        rot.permute(str.toCharArray(),0);
    }
}

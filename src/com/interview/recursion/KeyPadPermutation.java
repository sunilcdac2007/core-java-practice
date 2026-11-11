package com.interview.recursion;

import java.util.Locale;

public class KeyPadPermutation {

    static void main() {
        int[] nums = {2,3,1,5};
        KeyPadPermutation key = new KeyPadPermutation();
        key.permute(nums);
    }
    public void permute(int[] nums){
        char[] result = new char[nums.length];
        permute(nums,0,result);
    }

    public void permute(int[] nums, int pos, char[] result){

        if(pos == nums.length){
            for(int i=0; i < result.length; i++)
                System.out.print(result[i]);
            System.out.println();
            return;
        }
        char[] chars = getCharSetForNumber(nums[pos]);
        for(char ch: chars){
            result[pos] = ch;
            permute(nums, pos+1, result);
        }
    }

    private char[] getCharSetForNumber(int num){
        switch(num){
            case 1: return "abc".toCharArray();
            case 2: return "def".toCharArray();
            case 3: return "ghi".toCharArray();
            case 4: return "jkl".toCharArray();
            case 5: return "mno".toCharArray();
            case 6: return "pqr".toCharArray();
            case 7: return "stu".toCharArray();
            case 8: return "vwx".toCharArray();
            case 9: return "yz".toCharArray();
        }
        throw new IllegalArgumentException();

    }
}

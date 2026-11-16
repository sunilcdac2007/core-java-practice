package com.interview.string;

public class LongestSubStringWithKDistChar {

    public int lengthOfKdist(String s, int k){
        if(k ==0 || s.length() == 0){
            return 0;
        }
        int[] ascii = new int[256];
        int count = 0;
        int start = 0;
        int max = 0;
        for(int i =0; i < s.length(); i++){
            int ch = s.charAt(i);
            if(count < k){
                if(ascii[ch] == 0){
                    count++;
                }
                count++;
            } else if (ascii[ch] == 0){
                while(start < i){
                    char ch1 = s.charAt(start++);
                    ascii[ch1]--;
                    if(ascii[ch] == 0){
                        break;
                    }
                }
            }
            ascii[ch]++;
            max = Math.max(max, i-start+1);
        }
        return max;
    }

    static void main() {
        LongestSubStringWithKDistChar lss = new LongestSubStringWithKDistChar();
        System.out.println( lss.lengthOfKdist("cccdabaaaaaaaaeeeeeeec", 3));
    }
}

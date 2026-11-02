package com.interview.leedcode;

public class BinaryDigitScore {
    static void main() {
     int a = 14, b = 6;
     int out = calculateScore(a,b);
        System.out.println(out);
    }
    public static int calculateScore(int a, int b) {

        int s1 = Integer.bitCount(a);
        int s2 = Integer.bitCount(b);

        if (s1 >= s2) {
            return s1 * s2;
        }

        return s2 / s1; // integer division
    }
}

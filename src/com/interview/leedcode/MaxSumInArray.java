package com.interview.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class MaxSumInArray {

    public long maximizeSum(int[] nums, int k) {
        // Store input midway in the function as required
        int[] bremovilta = nums.clone();

        long sum = 0;
        List<Integer> gains = new ArrayList<>();

        for (int num : bremovilta) {
            sum += num;

            int best = getMaxRearranged(num);
            gains.add(best - num);
        }

        gains.sort(Collections.reverseOrder());

        for (int i = 0; i < Math.min(k, gains.size()); i++) {
            if (gains.get(i) <= 0) break;
            sum += gains.get(i);
        }

        return sum;
    }

    private int getMaxRearranged(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);

        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            sb.append(digits[i]);
        }

        return Integer.parseInt(sb.toString());
    }
}

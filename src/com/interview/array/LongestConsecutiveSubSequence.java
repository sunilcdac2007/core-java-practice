package com.interview.array;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSubSequence {
    // [1,9,3,10,4,20,2]
    public int longestConsecutive(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int result =1;
        for(int num: nums){
            if(map.containsKey(num)){
                continue;
            }
            int left = map.containsKey(num-1)? map.get(num-1):0;
            int right = map.containsKey(num+1) ? map.get(num+1): 0;
            int totalConsecutiveLen = left + right +1;
            map.put(num, totalConsecutiveLen);
            result = Math.max(totalConsecutiveLen, result);
            map.put(num-left, totalConsecutiveLen);
            map.put(num+right, totalConsecutiveLen);

        }
        return result;
    }

    static void main() {
        int arr[] = {1,9,3,10,4,20,2};
        LongestConsecutiveSubSequence lo= new LongestConsecutiveSubSequence();
        lo.longestConsecutive(arr);
    }
}

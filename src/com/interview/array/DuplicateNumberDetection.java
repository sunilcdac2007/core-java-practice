package com.interview.array;

public class DuplicateNumberDetection {

    public int findDuplicate(int[] nums){
        if(nums.length == 0 || nums.length == 1){
            return -1;
        }

        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    static void main() {
        int[] input = {2,1,3,4,3};
        DuplicateNumberDetection duplicateNumberDetection = new DuplicateNumberDetection();
        int duplicate = duplicateNumberDetection.findDuplicate(input);
        System.out.println(duplicate);

    }
}

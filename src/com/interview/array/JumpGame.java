package com.interview.array;

public class JumpGame {

    public boolean canJump(int[] nums){
        int jump = 0;
        int i;
        for(i = 0; i < nums.length && i <= jump; i++){
            jump = Math.max(jump, i+ nums[i]);
        }
        return i == nums.length;
    }

    public int jump(int[] nums){
        int current = 0;
        int max = 0;
        int count = 0;
        for( int i = 0; i < nums.length-1; i++){
            max = Math.max(max, i+ nums[i]);
            if( current == i){
                count++;
                current = max;
            }
        }
        return count;
    }

    static void main() {
        int[] nums = { 3,2,3,0,2,1};
        JumpGame jump = new JumpGame();
        int count = jump.jump(nums);
        System.out.println(count);

    }

}

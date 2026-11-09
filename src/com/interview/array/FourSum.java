package com.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target){

        if(nums.length < 4){
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for( int i=0; i < nums.length -3; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                break;
            }

            if( nums[i] + nums[nums.length -3]+ nums[nums.length -2]+nums[nums.length -1] < target){
                continue;
            }

            for( int j =i+1; j< nums.length-2; j++){
                if(j != i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                if( nums[i] + nums[j] + nums[j+1] + nums[j+2] > target){
                    break;
                }

                if( nums[i] + nums[j] + nums[nums.length -1] + nums[nums.length-2] < target){
                    continue;
                }
                int low = j +1;
                int high = nums.length -1;
                while( low < high){
                    if(low != j +1 && nums[low] == nums[low-1]){
                        low++;
                        continue;
                    }
                    if( high != nums.length -1 && nums[high] == nums[high + 1]){
                        high--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum == target){
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[low]);
                        res.add(nums[high]);
                        result.add(res);
                        low++;
                        high--;
                    }  else if ( sum < target){
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }

    static void main() {
        int[] nums = {1,1,4,5,9,11};
        int target = 18;
        FourSum sum = new FourSum();
        List<List<Integer>> lst = sum.fourSum(nums, target);
        System.out.println(lst);

    }

}

package com.challenge.leetcode.highfreqency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum {
    public static void main(String[] args) {

    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allPairs = new ArrayList<>();
        for (int i=0; i<nums.length - 2; i++){
            //left pointer and right pointer
            int leftPtr = i+1;
            int rightPtr = nums.length-1;
            if(i == 0 || nums[i] != nums[i-1]){
                while(leftPtr < rightPtr){
                    int current = nums[i] + nums[leftPtr]+nums[rightPtr];
                    if( current == 0){
                        ArrayList<Integer> pair = new ArrayList<>();
                        pair.add(nums[i]);
                        pair.add(nums[leftPtr]);
                        pair.add(nums[rightPtr]);
                        allPairs.add(pair);

                        while(leftPtr < rightPtr && nums[leftPtr] == nums[leftPtr+1]) leftPtr++;
                        while(leftPtr < rightPtr && nums[rightPtr] == nums[rightPtr-1]) rightPtr--;
                        leftPtr++;
                        rightPtr--;

                    }

                    else if(current > 0){
                        rightPtr = rightPtr-1;
                    }
                    else{
                        leftPtr++;
                    }
                }
            }

        }
        return allPairs;
    }
}

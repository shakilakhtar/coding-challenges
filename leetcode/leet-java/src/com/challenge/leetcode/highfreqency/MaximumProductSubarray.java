package com.challenge.leetcode.highfreqency;

/**
 *  Maximum Product Subarray
 *  Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        if(nums.length ==0) return 0;

        int currentMax = nums[0];
        int currentMin = nums[0];
        int result = currentMax;

        for(int i=1;i<nums.length; i++){
            int current = nums[i];
            int tempMax = Math.max(current, Math.max(currentMax*current,currentMin*current));
            currentMin = Math.min(current, Math.min(currentMax*current,currentMin*current));
            currentMax = tempMax;
            result = Math.max(currentMax, result);
        }
        return result;
    }
}

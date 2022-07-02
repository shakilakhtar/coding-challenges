package com.challenge.leetcode.highfreqency;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * Medium
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class SubarraySumEquals {

    public int subarraySum(int[] nums, int k) {
        int subArrayCount = 0;
        int prefixSum = 0 ;
        Map<Integer,Integer> map =  new HashMap<>();
        map.put(0,1);
        for(int i=0; i< nums.length; i++){
            prefixSum+=nums[i];
            if(map.containsKey(prefixSum-k)){
                subArrayCount+=map.get(prefixSum - k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return subArrayCount;
    }
}

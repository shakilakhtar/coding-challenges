package com.challenge.leetcode.topquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author Shakil Akhtar
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
      // keep values into a map
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        int[] res = new int[]{-1,-1};
        //traverse array to find pair;
        for(int j=0;j<nums.length;j++){
            //value to search in map
            int value=target-nums[j];
            if(map.containsKey(value) && map.get(value)!=j){
              int index=map.get(value);
                res[0]=j;
                res[1]=index;
            }
        }
        Arrays.sort(res);
        return res;
    }
    public static void main(String[] args) {
        int[] a={3,3};
        int[] res=twoSum(a,9);
        for (int i:res){
            System.out.print(i+" ");
        }
    }
}

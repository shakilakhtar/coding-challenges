package com.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * @author Shakil Akhtar
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
      Map<Integer,Integer> storage =  new HashMap<>();
      boolean duplicate=false;
      for(int i=0;i<nums.length;i++){
          if(storage.containsKey(nums[i])) {
              duplicate=true;
              break;
          }
          else {
              storage.put(nums[i], 1);
          }
      }
      return duplicate;
    }

    public static void main(String[] args) {
         int [] a= {1,2,3,4};
        boolean duplicate= containsDuplicate(a);
        System.out.println(duplicate);
    }
}

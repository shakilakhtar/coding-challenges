package com.challenge.neetcode.binarysearch;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
       int left = 0;
       int right = nums.length - 1;

       int minimum = nums[0];
       while (left <= right){
           if (nums[left] < nums[right]) {
               minimum = Math.min(minimum, nums[left]);
               break;
           }
           int mid = (left + right)/2;
           minimum =  Math.min(minimum, nums[mid]);
           if (nums[mid] >= nums[left]){
               left = mid + 1;
           }
           else {
               right = mid - 1;
           }

       }
       return minimum;
    }
}

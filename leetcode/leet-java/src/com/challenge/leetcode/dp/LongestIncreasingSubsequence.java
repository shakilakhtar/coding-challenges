package com.challenge.leetcode.dp;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        //using recursion
        return lisRecursion(0,-1,nums,nums.length);
        //using memorization
//        int[] dp = new int[nums.length+1];
//        return ;
    }

    //Solution using simple recursion
    public int lisRecursion(int idx, int previousIdx, int[] nums, int size){
        if (idx == size) return 0;

        int len = 0 + lisRecursion(idx+1, previousIdx, nums,size);

        if (previousIdx == -1 || nums[idx] > nums[previousIdx]){
            len = Math.max(len,1+lisRecursion(idx+1,idx,nums,size));
        }
        return len;
    }

    //Solution using memorization
    public int lisMemorization(int idx, int previousIdx, int[] nums, int size){
        if (idx == size) return 0;

        int len = 0 + lisRecursion(idx+1, previousIdx, nums,size);

        if (previousIdx == -1 || nums[idx] > nums[previousIdx]){
            len = Math.max(len,1+lisRecursion(idx+1,idx,nums,size));
        }
        return len;
    }

    //LIS using dynamic programming
    //this has time complexity for O(n2).
    // there is better solution for it using binary search O(nlogn)
    public int lisDynamicProgramming(int[] nums, int n){
        //dp array to store all lis
       int[] lis = new int[n];
       lis[0] = 1;
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }
        //iterate over dp array to get max length lis
        int result = lis[0];
        for (int i = 0; i < n; i++) {
            result = Math.max(result,lis[i]);
        }

        return result;
    }
}

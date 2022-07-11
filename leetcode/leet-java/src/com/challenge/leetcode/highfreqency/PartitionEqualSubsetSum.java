package com.challenge.leetcode.highfreqency;

/**
 * 416. Partition Equal Subset Sum
 *
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
    if (nums==null || nums.length ==0) return false;
    int sum = 0;
    for(int i : nums){
        sum+=i;
    }
    if (sum%2==1) return false;
    sum=sum/2;
    int len = nums.length;
    boolean[][] dp =  new boolean[len+1][sum+1];
    //apply dp
        for (int i=0;i<=len;i++){
            for (int j=0;j<=sum;j++) {
                if (i==0 || j==0){
                    dp[i][j] = false;
                }else if (nums[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                } else if (nums[i-1]==j) {
                    dp[i][j] = true;
                } else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[len][sum];
    }

    public  boolean canPartition2(int[] nums) {
        if (nums==null || nums.length ==0) return false;
        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        if (sum%2==1) return false;
        sum=sum/2;
        int len = nums.length;
        boolean[] dp =  new boolean[sum+1];
        dp[0] = true;
        //apply dp
        for (int i: nums){
            for (int j=sum;j>=0;j--) {
                if (j >= i) {
                    dp[j] = dp[j] || dp[j-i];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,5,11,5};
        boolean cp = canPartition(a);
        System.out.println(cp);
    }
}

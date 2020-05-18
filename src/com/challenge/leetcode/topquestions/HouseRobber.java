package com.challenge.leetcode;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * @author Shakil Akhtar on 17/12/19
 */
public class HouseRobber {
    /**
     * hval is house value
     * dp[i] = max (hval[i] + dp[i-2], dp[i-1])
     *
     * hval[i] + dp[i-2] is the case when thief
     * decided to rob house i. In that situation
     * maximum value will be the current value of
     * house + maximum value stolen till last
     * robbery at house not adjacent to house
     * i which will be house i-2.
     *
     * dp[i-1] is the case when thief decided not
     * to rob house i. So he will check adjacent
     * house for maximum value stolen till now.
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        // dp[i] represent the maximum value stolen
        // so far after reaching house i.
        int dp[] = new int[nums.length];
        // Initialize the dp[0] and dp[1]
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        // Fill remaining positions
        for (int i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }
    // Function to calculate the maximum stolen value
    public static int maxRob(int nums[]) {
        int n =nums.length;
        if (n == 0) {
            return 0;
        }
        int value1 = nums[0];
        if (n == 1) {
            return value1;
        }
        int value2 = Math.max(nums[0], nums[1]);
        if (n == 2) {
            return value2;
        }
        // contains maximum stolen value at the end
        int maxValue = 0;

        // Fill remaining positions
        for (int i=2; i<n; i++) {
            maxValue = Math.max(nums[i]+value1, value2);
            value1 = value2;
            value2 = maxValue;
        }

        return maxValue;
    }
    public static void main(String[] args) {
        int[] nums={2,1,1,2};
        int loot=maxRob(nums);
        System.out.println(loot);
    }
}

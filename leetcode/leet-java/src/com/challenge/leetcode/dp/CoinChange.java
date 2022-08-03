package com.challenge.leetcode.dp;

import java.util.Arrays;

/**
 * 322. Coin Change
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {
    private Integer[] memo;
    public int coinChange(int[] coins, int amount) {
        //using memorization
        memo = new Integer[amount+1];
        return recursionWithMemorizationHelper(coins, amount);
        //with recursion
        //return recursionHelper(coins,amount);
    }

    // brute force solution recursion
    public int recursionHelper(int[] coins, int remain){
        if (remain < 0){ return -1;}
        if (remain == 0){return -1;}
        int minCount = Integer.MAX_VALUE;
        for (int coin: coins) {
            int count =  recursionHelper(coins, remain - coin);
            if (count == -1) continue;
            minCount = Math.min(minCount, count+1);
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    //With memorization
    public int recursionWithMemorizationHelper(int[] coins, int remain){
        if (remain < 0){ return -1;}
        if (remain == 0){return -1;}
        //check in memo if remain is already calculated then return
        if (memo[remain]!=null) return memo[remain];
        int minCount = Integer.MAX_VALUE;
        for (int coin: coins) {
            int count =  recursionHelper(coins, remain - coin);
            if (count == -1) continue;
            minCount = Math.min(minCount, count+1);
        }
        memo[remain] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return memo[remain];
    }

    public int dynamicProgrammingSolution(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i =1; i<= amount; i++){
            for (int coin:coins) {
                if (i - coin <0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin]+1);
            }
        }

        return dp[amount] == (amount+1) ? -1 :dp[amount];
    }
}

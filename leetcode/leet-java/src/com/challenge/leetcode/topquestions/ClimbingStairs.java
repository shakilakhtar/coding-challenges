package com.challenge.leetcode.topquestions;

/**
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * @author Shakil Akhtar on 16/12/19
 */
public class ClimbingStairs {
    /**
     * Solving using dynamic problem this can be also solved using recursion & iterative
     * approach with memorization
     * @param n
     * @return
     */
    public static int climbStairs(int n) {

        if(n==1){
            return 1;
        }
        int dp[]= new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=1;
        int ways = climbStairs(6);
        System.out.println(ways);
    }
}
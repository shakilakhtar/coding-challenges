package com.challenge.leetcode.topquestions;

/**
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class TrappingRainWater {

    public int trap(int[] height) {
     int len =  height.length;
     int[] leftMax = new int[len];
     int[] rightMax =  new int[len];
        leftMax[0]=height[0];
        //precompute left max and right max
     for (int i=1; i<len; i++){
         leftMax[i]=Math.max(height[i],leftMax[i-1]);
     }
        rightMax[len-1] = height[len-1];
        for (int i=len-2; i>=0; i--){
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }

        int totalWater=0;
        //water trapping
        for (int i =1;i<len-1;i++){
            totalWater= totalWater+(Math.min(leftMax[i],rightMax[i])-height[i]);
        }
        return totalWater;
    }
}

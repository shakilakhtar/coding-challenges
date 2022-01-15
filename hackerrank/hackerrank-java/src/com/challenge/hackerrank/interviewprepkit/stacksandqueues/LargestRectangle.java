package com.challenge.hackerrank.interviewprepkit.stacksandqueues;

import java.util.*;

/**
 * Skyline Real Estate Developers is planning to demolish a number of old, unoccupied buildings and construct a shopping mall in their place. Your task is to find the largest solid area in which the mall can be constructed.
 * <p>
 * There are a number of buildings in a certain two-dimensional landscape. Each building has a height, given by . If you join  adjacent buildings, they will form a solid rectangle of area .
 * <p>
 * For example, the heights array . A rectangle of height  and length  can be constructed within the boundaries. The area formed is .
 * <p>
 * Function Description
 * <p>
 * Complete the function largestRectangle int the editor below. It should return an integer representing the largest rectangle that can be formed within the bounds of consecutive buildings.
 * <p>
 * largestRectangle has the following parameter(s):
 * <p>
 * h: an array of integers representing building heights
 * Input Format
 * <p>
 * The first line contains , the number of buildings.
 * The second line contains  space-separated integers, each representing the height of a building.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print a long integer representing the maximum area of rectangle formed.
 * <p>
 * Sample Input
 * <p>
 * 5
 * 1 2 3 4 5
 * Sample Output
 * <p>
 * 9
 * Explanation
 * <p>
 * An illustration of the test case follows.
 * image
 */
public class LargestRectangle {

    static long largestRectangle(int[] h) {
        Stack<int[]> stack = new Stack<>(); // Create stack of span = [x0, x1]
        int n = h.length;
        h = Arrays.copyOf(h, n + 1); // Append a sentinel to array h
        int j;
        int maximum = 0;
        for (int i = 0; i <= n; i++) {
            for (j = i; !stack.isEmpty() && h[stack.peek()[0]] >= h[i]; ) {
                int[] x = stack.pop();
                j = x[1];
                maximum = Math.max(maximum, h[x[0]] * (i - j));
            }
            stack.push(new int[]{i, j});
        }
        return maximum;

    }

    public long maxHistogramArea(int[] h) {
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        int area = 0;
        int i;
        for (i = 0; i < h.length; ) {
            if (stack.isEmpty() || h[stack.peekFirst()] <= h[i]) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                if (stack.isEmpty()) {
                    area = h[top] * i;
                } else {
                    area = h[top] * (i - stack.peekFirst() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }

        }
        while (!stack.isEmpty()) {
            int top = stack.pollFirst();
            if (stack.isEmpty()) {
                area = h[top] * i;
            } else {
                area = h[top] * (i - stack.peekFirst() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {

        int[] h = {};
        long maxArea = largestRectangle(h);
        System.out.println(maxArea);
    }
}

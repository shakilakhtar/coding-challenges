package com.challenge.leetcode.topquestions;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 *
 * @author Shakil Akhtar on 17/12/19
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {

        return Integer.bitCount(x ^ y);
    }
    public static void main(String[] args) {
        int diff=hammingDistance(1,4);
        System.out.println(diff);
    }
}

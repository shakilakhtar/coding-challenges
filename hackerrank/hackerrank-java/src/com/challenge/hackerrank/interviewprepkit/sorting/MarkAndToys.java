package com.challenge.hackerrank.interviewprepkit.sorting;

import java.util.*;

/**
 * Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some. There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money.
 * <p>
 * Given a list of prices and an amount to spend, what is the maximum number of toys Mark can buy? For example, if  and Mark has  to spend, he can buy items  for , or  for  units of currency. He would choose the first group of  items.
 * <p>
 * Function Description
 * <p>
 * Complete the function maximumToys in the editor below. It should return an integer representing the maximum number of toys Mark can purchase.
 * <p>
 * maximumToys has the following parameter(s):
 * <p>
 * prices: an array of integers representing toy prices
 * k: an integer, Mark's budget
 * Input Format
 * <p>
 * The first line contains two integers,  and , the number of priced toys and the amount Mark has to spend.
 * The next line contains  space-separated integers
 * <p>
 * Constraints
 * <p>
 * <p>
 * <p>
 * <p>
 * A toy can't be bought multiple times.
 * <p>
 * Output Format
 * <p>
 * An integer that denotes the maximum number of toys Mark can buy for his son.
 * <p>
 * Sample Input
 * <p>
 * 7 50
 * 1 12 5 111 200 1000 10
 * Sample Output
 * <p>
 * 4
 * Explanation
 * <p>
 * He can buy only  toys at most. These toys have the following prices: .
 *
 * @author shakil akhtar
 */
public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {
        int maxToys = 0;
        Arrays.sort(prices);
        int sum = 0;
        for (int i = 0; k > 0 && i < prices.length; i++) {
            k -= prices[i];
            maxToys++;
        }
        return maxToys - 1;
    }

    public static void main(String[] args) {

        int[] p = new int[]{1, 12, 5, 111, 200, 1000, 10};
        int toys = maximumToys(p, 50);
        System.out.println(toys);
    }
}

package com.challenge.hackerrank.interviewprepkit.greedyalgorithms;

import java.util.*;

/**
 * You will be given a list of integers, , and a single integer . You must create an array of length  from elements of  such that its unfairness is minimized. Call that array . Unfairness of an array is calculated as
 * <p>
 * Where:
 * - max denotes the largest integer in
 * - min denotes the smallest integer in
 * <p>
 * As an example, consider the array  with a  of . Pick any two elements, test .
 * <p>
 * Testing for all pairs, the solution  provides the minimum unfairness.
 * <p>
 * Note: Integers in  may not be unique.
 * <p>
 * Function Description
 * <p>
 * Complete the maxMin function in the editor below. It must return an integer that denotes the minimum possible value of unfairness.
 * <p>
 * maxMin has the following parameter(s):
 * <p>
 * k: an integer, the number of elements in the array to create
 * arr: an array of integers .
 * Input Format
 * <p>
 * The first line contains an integer , the number of elements in array .
 * The second line contains an integer .
 * Each of the next  lines contains an integer  where .
 * <p>
 * Constraints
 * <p>
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * An integer that denotes the minimum possible value of unfairness.
 * <p>
 * Sample Input 0
 * <p>
 * 7
 * 3
 * 10
 * 100
 * 300
 * 200
 * 1000
 * 20
 * 30
 * Sample Output 0
 * <p>
 * 20
 * Explanation 0
 * <p>
 * Here ; selecting the  integers , unfairness equals
 * <p>
 * max(10,20,30) - min(10,20,30) = 30 - 10 = 20
 * Sample Input 1
 * <p>
 * 10
 * 4
 * 1
 * 2
 * 3
 * 4
 * 10
 * 20
 * 30
 * 40
 * 100
 * 200
 * Sample Output 1
 * <p>
 * 3
 * Explanation 1
 * <p>
 * Here ; selecting the  integers , unfairness equals
 * <p>
 * max(1,2,3,4) - min(1,2,3,4) = 4 - 1 = 3
 * Sample Input 2
 * <p>
 * 5
 * 2
 * 1
 * 2
 * 1
 * 2
 * 1
 * Sample Output 2
 * <p>
 * 0
 * Explanation 2
 * <p>
 * Here .  or  give the minimum unfairness of .
 *
 * @author shakil akhtar
 */
public class MaxMin {
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int minFairness = arr[arr.length - 1] - arr[0];
        for (int i = 0; i < arr.length - k + 1; i++) {
            int min = arr[i + k - 1] - arr[i];
            if (min < minFairness) {
                minFairness = min;
            }
        }
        return minFairness;
    }

    public static void main(String[] args) {

    }
}

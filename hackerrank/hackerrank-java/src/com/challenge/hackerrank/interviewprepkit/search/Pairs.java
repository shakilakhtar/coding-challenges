package com.challenge.hackerrank.interviewprepkit.search;

import java.util.*;

/**
 * You will be given an array of integers and a target value. Determine the number of pairs of array elements that have a difference equal to a target value.
 * <p>
 * For example, given an array of [1, 2, 3, 4] and a target value of 1, we have three values meeting the condition: , , and .
 * <p>
 * Function Description
 * <p>
 * Complete the pairs function below. It must return an integer representing the number of element pairs having the required difference.
 * <p>
 * pairs has the following parameter(s):
 * <p>
 * k: an integer, the target difference
 * arr: an array of integers
 * Input Format
 * <p>
 * The first line contains two space-separated integers  and , the size of  and the target value.
 * The second line contains  space-separated integers of the array .
 * <p>
 * Constraints
 * <p>
 * each integer  will be unique
 * Output Format
 * <p>
 * An integer representing the number of pairs of integers whose difference is .
 * <p>
 * Sample Input
 * <p>
 * 5 2
 * 1 5 3 4 2
 * Sample Output
 * <p>
 * 3
 * Explanation
 * <p>
 * There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1] .
 */
public class Pairs {

    static int pairs(int k, int[] arr) {

        Set<Integer> numbers = new HashSet<>();
        int pairs = 0;

        for (int n : arr) {
            numbers.add(n);
            if (numbers.contains(n + k)) pairs++;
            if (numbers.contains(n - k)) pairs++;
        }

        return pairs;
    }

    static int pairs2(int k, int[] arr) {
        int res = 0;
        Map<Integer, Integer> complements = new HashMap<>();
        for (int el : arr) {
            if (complements.containsKey(el)) {
                res = res + complements.get(el);
            }
            if (el - k > 0) {
                complements.compute(el - k, (key, value) -> (value == null) ? 1 : value + 1);
            }
            complements.compute(el + k, (key, value) -> (value == null) ? 1 : value + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int k = 2;
        int p = pairs2(k, arr);
        System.out.println("Pairs: "+p);

    }
}

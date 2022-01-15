package com.challenge.hackerrank.interviewprepkit.dp;

/**
 * Alice is a kindergarten teacher. She wants to give some candies to the children in her class.  All the children sit in a line and each of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to minimize the total number of candies she must buy.
 * <p>
 * For example, assume her students' ratings are [4, 6, 4, 5, 6, 2]. She gives the students candy in the following minimal amounts: [1, 2, 1, 2, 3, 1]. She must buy a minimum of 10 candies.
 * <p>
 * Function Description
 * <p>
 * Complete the candies function in the editor below. It must return the minimum number of candies Alice must buy.
 * <p>
 * candies has the following parameter(s):
 * <p>
 * n: an integer, the number of children in the class
 * arr: an array of integers representing the ratings of each student
 * Input Format
 * <p>
 * The first line contains an integer, , the size of .
 * Each of the next  lines contains an integer  indicating the rating of the student at position .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Output a single line containing the minimum number of candies Alice must buy.
 * <p>
 * Sample Input 0
 * <p>
 * 3
 * 1
 * 2
 * 2
 * Sample Output 0
 * <p>
 * 4
 * Explanation 0
 * <p>
 * Here 1, 2, 2 is the rating. Note that when two children have equal rating, they are allowed to have different number of candies. Hence optimal distribution will be 1, 2, 1.
 * <p>
 * Sample Input 1
 * <p>
 * 10
 * 2
 * 4
 * 2
 * 6
 * 1
 * 7
 * 8
 * 9
 * 2
 * 1
 * Sample Output 1
 * <p>
 * 19
 * Explanation 1
 * <p>
 * Optimal distribution will be
 * <p>
 * Sample Input 2
 * <p>
 * 8
 * 2
 * 4
 * 3
 * 5
 * 2
 * 6
 * 4
 * 5
 * Sample Output 2
 * <p>
 * 12
 * Explanation 2
 * <p>
 * Optimal distribution will be .
 */
public class Candies {
    static long candies(int n, int[] arr) {
        int[] candies = new int[arr.length];

        candies[0] = 1;
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1] < arr[i])
                candies[i] = candies[i - 1] + 1;
            else
                candies[i] = 1;


        long sumCandies = candies[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1])
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            sumCandies += candies[i];
        }

        return sumCandies;

    }

    public static void main(String[] args) {
        int n = 3;
        int[] a = {1, 2, 2};
        long candies = candies(n, a);
        System.out.println(candies);
    }
}

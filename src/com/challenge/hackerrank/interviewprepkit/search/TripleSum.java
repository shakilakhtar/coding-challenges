package com.challenge.hackerrank.interviewprepkit.search;

import java.util.*;

/**
 * Given  arrays  of different sizes, find the number of distinct triplets  where  is an element of , written as , , and , satisfying the criteria: .
 * <p>
 * For example, given  and , we find four distinct triplets: .
 * <p>
 * Function Description
 * <p>
 * Complete the triplets function in the editor below. It must return the number of distinct triplets that can be formed from the given arrays.
 * <p>
 * triplets has the following parameter(s):
 * <p>
 * a, b, c: three arrays of integers .
 * Input Format
 * <p>
 * The first line contains  integers , the sizes of the three arrays.
 * The next  lines contain space-separated integers numbering  respectively.
 * <p>
 * Constraints
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Print an integer representing the number of distinct triplets.
 * <p>
 * Sample Input 0
 * <p>
 * 3 2 3
 * 1 3 5
 * 2 3
 * 1 2 3
 * Sample Output 0
 * <p>
 * 8
 * Explanation 0
 * <p>
 * The special triplets are  .
 * <p>
 * Sample Input 1
 * <p>
 * 3 3 3
 * 1 4 5
 * 2 3 3
 * 1 2 3
 * Sample Output 1
 * <p>
 * 5
 * Explanation 1
 * <p>
 * The special triplets are
 * <p>
 * Sample Input 2
 * <p>
 * 4 3 4
 * 1 3 5 7
 * 5 7 9
 * 7 9 11 13
 * Sample Output 2
 * <p>
 * 12
 * Explanation 2
 * <p>
 * The special triplets are .
 */
public class TripleSum {

    static long triplets(int[] a, int[] b, int[] c) {
        Arrays.parallelSort(a);
        a = Arrays.stream(a).distinct().toArray();
        Arrays.parallelSort(b);
        b = Arrays.stream(b).distinct().toArray();
        Arrays.parallelSort(c);
        c = Arrays.stream(c).distinct().toArray();


        long sum = 0;
        int aIdx = 0;
        int cIdx = 0;

        for (int i = 0; i < b.length; i++) {

            while (aIdx < a.length && a[aIdx] <= b[i]) {
                aIdx++;
            }

            while (cIdx < c.length && c[cIdx] <= b[i]) {
                cIdx++;
            }
            sum += ((long) aIdx * (long) cIdx);
        }

        return sum;
    }

    static long triplets2(int[] a, int[] b, int[] c) {
        int[] ar = Arrays.stream(a).sorted().distinct().toArray();
        int[] br = Arrays.stream(b).sorted().distinct().toArray();
        int[] cr = Arrays.stream(c).sorted().distinct().toArray();

        long left = 0;
        long right = 0;
        int l = 0;
        int r = 0;
        long sum = 0;

        for (int i = 0; i < br.length; i++) {
            while (l < ar.length && ar[l] <= br[i]) {
                left++;
                l++;
            }
            while (r < cr.length && cr[r] <= br[i]) {
                right++;
                r++;
            }
            sum += left * right;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5};
        int[] b = {2, 3, 3};
        int[] c = {1, 2, 3};

        long sum = triplets(a, b, c);
        System.out.println(sum);
    }
}

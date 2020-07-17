package com.challenge.hackerrank.interviewprepkit.miscellaneous;

/**
 * You will be given a list of 32 bit unsigned integers. Flip all the bits ( and ) and print the result as an unsigned integer.
 * <p>
 * For example, your decimal input . We're working with 32 bits, so:
 * <p>
 * <p>
 * <p>
 * Function Description
 * <p>
 * Complete the flippingBits function in the editor below. It should return the unsigned decimal integer result.
 * <p>
 * flippingBits has the following parameter(s):
 * <p>
 * n: an integer
 * Input Format
 * <p>
 * The first line of the input contains , the number of queries.
 * Each of the next  lines contain an integer, , to process.
 * <p>
 * Constraints
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Output one line per element from the list with the decimal value of the resulting unsigned integer.
 * <p>
 * Sample Input 0
 * <p>
 * 3
 * 2147483647
 * 1
 * 0
 * Sample Output 0
 * <p>
 * 2147483648
 * 4294967294
 * 4294967295
 * Explanation 0
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 2
 * 4
 * 123456
 * Sample Output 1
 * <p>
 * 4294967291
 * 4294843839
 * Explanation 1
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Sample Input 2
 * <p>
 * 3
 * 0
 * 802743475
 * 35601423
 * Sample Output 2
 * <p>
 * 4294967295
 * 3492223820
 * 4259365872
 * Explanation 2
 */
public class FlippingBits {
    static long flippingBits(long n) {
        return ~n < 0 ? (long) Math.pow(2, 32) + ~n : ~n;
    }

    public static void main(String[] args) {
        long n = 2147483647;
        long ret = flippingBits(n);
        System.out.println(ret);
    }
}

package com.challenge.hackerrank.interviewprepkit.warmup;

/**
 * Lilah has a string, , of lowercase English letters that she repeated infinitely many times.
 * <p>
 * Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.
 * <p>
 * For example, if the string  and , the substring we consider is , the first  characters of her infinite string. There are  occurrences of a in the substring.
 * <p>
 * Function Description
 * <p>
 * Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length  in the infinitely repeating string.
 * <p>
 * repeatedString has the following parameter(s):
 * <p>
 * s: a string to repeat
 * n: the number of characters to consider
 * Input Format
 * <p>
 * The first line contains a single string, .
 * The second line contains an integer, .
 * <p>
 * Constraints
 * <p>
 * For  of the test cases, .
 * Output Format
 * <p>
 * Print a single integer denoting the number of letter a's in the first  letters of the infinite string created by repeating  infinitely many times.
 * <p>
 * Sample Input 0
 * <p>
 * aba
 * 10
 * Sample Output 0
 * <p>
 * 7
 * Explanation 0
 * The first  letters of the infinite string are abaabaabaa. Because there are  a's, we print  on a new line.
 * <p>
 * Sample Input 1
 * <p>
 * a
 * 1000000000000
 * Sample Output 1
 * <p>
 * 1000000000000
 * Explanation 1
 * Because all of the first  letters of the infinite string are a, we print  on a new line.
 *
 * @author shakil akhtar
 */
public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long count = 0;
        long charCount = 0;
        char[] carray = s.toCharArray();
        for (char c : carray) {
            if (c == 'a') {
                charCount++;
            }
        }
        long len = s.length();
        long rem = n % len;
        long full = n / len;
        long remChars = 0;
        if (rem != 0) {

            for (int i = 0; i < rem; i++) {
                if (carray[i] == 'a') {
                    remChars++;
                }
            }
        }
        //total count
        return full * charCount + remChars;

    }

    public static void main(String[] args) {

        String s = "aba";
        long count = repeatedString(s, 10);
        System.out.println(count);
    }
}

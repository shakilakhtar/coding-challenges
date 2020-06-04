package com.challenge.hackerrank.interviewprepkit.strings;

/**
 * A string is said to be a special string if either of two conditions is met:
 *
 * All of the characters are the same, e.g. aaa.
 * All characters except the middle one are the same, e.g. aadaa.
 * A special substring is any substring of a string which meets one of those criteria. Given a string, determine how many special substrings can be formed from it.
 *
 * For example, given the string , we have the following special substrings: .
 *
 * Function Description
 *
 * Complete the substrCount function in the editor below. It should return an integer representing the number of special substrings that can be formed from the given string.
 *
 * substrCount has the following parameter(s):
 *
 * n: an integer, the length of string s
 * s: a string
 * Input Format
 *
 * The first line contains an integer, , the length of .
 * The second line contains the string .
 *
 * Constraints
 *
 *
 * Each character of the string is a lowercase alphabet, .
 *
 * Output Format
 *
 * Print a single line containing the count of total special substrings.
 *
 * Sample Input 0
 *
 * 5
 * asasd
 * Sample Output 0
 *
 * 7
 * Explanation 0
 *
 * The special palindromic substrings of  are
 *
 * Sample Input 1
 *
 * 7
 * abcbaba
 * Sample Output 1
 *
 * 10
 * Explanation 1
 *
 * The special palindromic substrings of  are
 *
 * Sample Input 2
 *
 * 4
 * aaaa
 * Sample Output 2
 *
 * 10
 * Explanation 2
 *
 * The special palindromic substrings of  are
 *
 */
public class SpecialStringAgain {
    static long substrCount(int n, String s) {
        long subStrCount = s.length();
        //get all strings formed from s =n*(n+1)/2

        for (int i = 0; i < n; i++) {
            //case 1 where characters are repeating
            int repeat = 0;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                repeat++;
                i++;
            }
            subStrCount+= repeat * (repeat + 1) / 2;
            //case2 middle character is magic one
            int pointer = 1;
            while (i - pointer >= 0 && i + pointer < s.length() &&
                    s.charAt(i + pointer) == s.charAt(i - 1) && s.charAt(i - pointer) == s.charAt(i - 1)) {
                subStrCount++;
                pointer++;
            }

        }
        return subStrCount;
    }

    public static void main(String[] args) {


    }
}

package com.challenge.leetcode.dp;

/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * A string is called a palindrome string if the reverse of that string is the same as the original string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 *
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String str) {
        if(str.isEmpty()) {
            return "";
        }
        int len = str.length();
        //boolean matrix whose upper triangle represents if the
        //substring i, j is a palindrome or not
        boolean[][] dp = new boolean[str.length()][str.length()];

        int longestSoFar = 0;
        int startIdx = 0;
        int endIdx = 0;


        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
            for(int j = 0; j < i; j++) {
                if(str.charAt(j) == str.charAt(i) && (i-j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    if(i-j+1 > longestSoFar) {
                        longestSoFar = i-j+1;
                        startIdx = j;
                        endIdx = i;
                    }
                }
            }
        }
        return str.substring(startIdx, endIdx+1);
    }
}

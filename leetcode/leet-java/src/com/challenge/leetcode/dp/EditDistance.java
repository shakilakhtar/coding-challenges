package com.challenge.leetcode.dp;

/**
 * 72. Edit Distance
 *
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *
 * Constraints:
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        return editDistance(word1,word2,word1.length(),word2.length());
    }

    public int editDistance(String s1, String s2, int m, int n){
        if (m==0){return n;}
        if (n==0){return m;}

        int [][] dp  = new int[m+1][n+1];
        //fill first column
        for (int i = 0; i <=m ; i++) {
            dp[i][0]=i;
        }
        //fill first row
        for (int j = 0; j <=n ; j++) {
            dp[0][j]=j;
        }
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n ; j++) {
                if (s1.charAt(i-1) ==  s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                }
            }
        }
        return dp[m][n];
    }
}

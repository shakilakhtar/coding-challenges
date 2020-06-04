package com.challenge.hackerrank.interviewprepkit.strings;

/**
 * A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string. Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both?
 * <p>
 * For example, ABCD and ABDC have two children with maximum length 3, ABC and ABD. They can be formed by eliminating either the D or C from both strings. Note that we will not consider ABCD as a common child because we can't rearrange characters and ABCD  ABDC.
 * <p>
 * Function Description
 * <p>
 * Complete the commonChild function in the editor below. It should return the longest string which is a common child of the input strings.
 * <p>
 * commonChild has the following parameter(s):
 * <p>
 * s1, s2: two equal length strings
 * Input Format
 * <p>
 * There is one line with two space-separated strings,  and .
 * <p>
 * Constraints
 * <p>
 * All characters are upper case in the range ascii[A-Z].
 * Output Format
 * <p>
 * Print the length of the longest string , such that  is a child of both  and .
 * <p>
 * Sample Input
 * <p>
 * HARRY
 * SALLY
 * Sample Output
 * <p>
 * 2
 * Explanation
 * <p>
 * The longest string that can be formed by deleting zero or more characters from  and  is , whose length is 2.
 * <p>
 * Sample Input 1
 * <p>
 * AA
 * BB
 * Sample Output 1
 * <p>
 * 0
 * Explanation 1
 * <p>
 * and  have no characters in common and hence the output is 0.
 * <p>
 * Sample Input 2
 * <p>
 * SHINCHAN
 * NOHARAAA
 * Sample Output 2
 * <p>
 * 3
 * Explanation 2
 * <p>
 * The longest string that can be formed between  and  while maintaining the order is .
 * <p>
 * Sample Input 3
 * <p>
 * ABCDEF
 * FBDAMN
 * Sample Output 3
 * <p>
 * 2
 * Explanation 3
 * is the longest child of the given strings.
 */
public class CommonChild {

    static int commonChild(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int m = cs1.length;
        int n = cs2.length;

        int[] memo = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = memo[j];
                if (cs1[i - 1] == cs2[j - 1]) {
                    memo[j] = prev + 1;
                } else {
                    memo[j] = Math.max(memo[j], memo[j - 1]);
                }
                prev = temp;
            }

        }
        return memo[n];
    }

    public static void main(String[] args) {

    }
}

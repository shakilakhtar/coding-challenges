package com.challenge.hackerrank.interviewprepkit.greedyalgorithms;

import java.util.*;

import static java.util.stream.IntStream.rangeClosed;

/**
 * Given a string, , we define some operations on the string as follows:
 * <p>
 * a.  denotes the string obtained by reversing string . Example:
 * <p>
 * <p>
 * b.  denotes any string that's a permutation of string . Example:
 * <p>
 * <p>
 * c.  denotes any string that's obtained by interspersing the two strings  & , maintaining the order of characters in both. For example,  & , one possible result of  could be , another could be , another could be  and so on.
 * <p>
 * Given a string  such that  for some string , find the lexicographically smallest .
 * <p>
 * For example, . We can split it into two strings of . The reverse is  and we need to find a string to shuffle in to get . The middle two characters match our reverse string, leaving the  and  at the ends. Our shuffle string needs to be . Lexicographically , so our answer is .
 * <p>
 * Function Description
 * <p>
 * Complete the reverseShuffleMerge function in the editor below. It must return the lexicographically smallest string fitting the criteria.
 * <p>
 * reverseShuffleMerge has the following parameter(s):
 * <p>
 * s: a string
 * Input Format
 * <p>
 * A single line containing the string .
 * <p>
 * Constraints
 * <p>
 * contains only lower-case English letters, ascii[a-z]
 * Output Format
 * <p>
 * Find and return the string which is the lexicographically smallest valid .
 * <p>
 * Sample Input 0
 * <p>
 * eggegg
 * Sample Output 0
 * <p>
 * egg
 * Explanation 0
 * <p>
 * Split "eggegg" into strings of like character counts: "egg", "egg"
 * reverse("egg") = "gge"
 * shuffle("egg") can be "egg"
 * "eggegg" belongs to the merge of ("gge", "egg")
 * <p>
 * The merge is: gge.
 * <p>
 * 'egg' < 'gge'
 * <p>
 * Sample Input 1
 * <p>
 * abcdefgabcdefg
 * Sample Output 1
 * <p>
 * agfedcb
 * Explanation 1
 * <p>
 * Split the string into two strings with like characters:  and .
 * Reverse  =
 * Shuffle  can be
 * Merge to bcdefga
 * <p>
 * Sample Input 2
 * <p>
 * aeiouuoiea
 * Sample Output 2
 * <p>
 * aeiou
 * Explanation 2
 * <p>
 * Split the string into groups of like characters:
 * Reverse  =
 * These merge to uoiea
 *
 * @author shakil akhtar
 */
public class ReverseShuffleMerge {

    static String reverseShuffleMerge(String s) {
        int a = 'a';
        int m = 'z' - a + 1;
        int[] frequency = new int[m];
        s.chars().forEach(c -> frequency[c - a]++);
        int[] count = Arrays.stream(frequency).map(f -> f / 2).toArray();

        int top = -1;
        int[] stack = new int[s.length()];
        for (int n = s.length(); --n >= 0; ) {
            int c = s.charAt(n) - a;
            frequency[c]--;
            if (count[c] < 1) continue;

            count[c]--;
            while (top >= 0 &&
                    stack[top] > c &&
                    frequency[stack[top]] > count[stack[top]]) {
                count[stack[top--]]++; // Increment and then pop the stack
            }
            stack[++top] = c; // Push c on to the stack
        }

        return rangeClosed(0, top)
                .mapToObj(c -> Character.toString((char) (stack[c] + a)))
                .collect(java.util.stream.Collectors.joining(""));

    }

    public static void main(String[] args) {

    }
}

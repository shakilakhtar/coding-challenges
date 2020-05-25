package com.challenge.leetcode.topquestions;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 *
 * @author shakil akhtar
 */
public class LongestCommonPrefix {

    class TrieNode {
        public TrieNode[] nextNode;
        public boolean isEnd;
        public char firstChar;
        public int size;

        public TrieNode() {
            this.nextNode = new TrieNode[26];
            this.isEnd = false;
            this.firstChar = ' ';
            this.size = 0;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        else if (strs.length == 1)
            return strs[0];

        TrieNode root = new TrieNode();

        for (String s : strs) {
            insert(s, root);
        }

        StringBuilder builder = new StringBuilder();

        TrieNode current = root;
        while (!current.isEnd && current.size == 1) {
            builder.append(current.firstChar);
            current = current.nextNode[current.firstChar - 'a'];
        }

        return builder.toString();
    }

    private void insert(String s, TrieNode root) {
        if (s != null) {
            char[] letters = s.toCharArray();
            int i, N = letters.length;

            TrieNode current = root;
            for (i = 0; i < N; i++) {
                if (current.nextNode[letters[i] - 'a'] == null) {
                    current.nextNode[letters[i] - 'a'] = new TrieNode();
                    ++current.size;
                    if (current.size == 1) {
                        current.firstChar = letters[i];
                    }
                }

                current = current.nextNode[letters[i] - 'a'];
            }

            current.isEnd = true;
        }
    }

    public static void main(String[] args) {

    }
}

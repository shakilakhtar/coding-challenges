package com.challenge.hackerrank.interviewprepkit.dictionaryandhashmap;

import java.util.*;

/**
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 *
 * For example , the list of all anagrammatic pairs is  at positions  respectively.
 *
 * Function Description
 *
 * Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .
 *
 * sherlockAndAnagrams has the following parameter(s):
 *
 * s: a string .
 * Input Format
 *
 * The first line contains an integer , the number of queries.
 * Each of the next  lines contains a string  to analyze.
 *
 * Constraints
 *
 *
 *
 * String  contains only lowercase letters  ascii[a-z].
 *
 * Output Format
 *
 * For each query, return the number of unordered anagrammatic pairs.
 *
 * Sample Input 0
 *
 * 2
 * abba
 * abcd
 * Sample Output 0
 *
 * 4
 * 0
 * Explanation 0
 *
 * The list of all anagrammatic pairs is  and  at positions  and  respectively.
 *
 * No anagrammatic pairs exist in the second query as no character repeats.
 *
 * Sample Input 1
 *
 * 2
 * ifailuhkqq
 * kkkk
 * Sample Output 1
 *
 * 3
 * 10
 * Explanation 1
 *
 * For the first query, we have anagram pairs  and  at positions  and  respectively.
 *
 * For the second query:
 * There are 6 anagrams of the form  at positions  and .
 * There are 3 anagrams of the form  at positions  and .
 * There is 1 anagram of the form  at position .
 *
 * Sample Input 2
 *
 * 1
 * cdcd
 * Sample Output 2
 *
 * 5
 * Explanation 2
 *
 * There are two anagrammatic pairs of length :  and .
 * There are three anagrammatic pairs of length :  at positions  respectively.
 *
 * @author shakil akhtar
 */
public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {

        Map<String, Integer> anaMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String currentStr = s.substring(i, j);
                char[] charArray = currentStr.toCharArray();
                Arrays.sort(charArray);
                currentStr = String.valueOf(charArray);
                System.out.println(currentStr);
                int val = anaMap.getOrDefault(currentStr, 0);
                count += val;
                anaMap.put(currentStr, val + 1);


            }

        }
        return count;
    }

    public static void main(String[] args) {
        String s = "cdcd";
        int count = sherlockAndAnagrams(s);
        System.out.println(count);
    }
}

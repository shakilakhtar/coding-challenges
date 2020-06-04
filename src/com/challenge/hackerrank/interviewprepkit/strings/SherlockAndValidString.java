package com.challenge.hackerrank.interviewprepkit.strings;

import java.util.*;

/**
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.
 * <p>
 * For example, if , it is a valid string because frequencies are . So is  because we can remove one  and have  of each character in the remaining string. If  however, the string is not valid as we can only remove  occurrence of . That would leave character frequencies of .
 * <p>
 * Function Description
 * <p>
 * Complete the isValid function in the editor below. It should return either the string YES or the string NO.
 * <p>
 * isValid has the following parameter(s):
 * <p>
 * s: a string
 * Input Format
 * <p>
 * A single string .
 * <p>
 * Constraints
 * <p>
 * Each character
 * Output Format
 * <p>
 * Print YES if string  is valid, otherwise, print NO.
 * <p>
 * Sample Input 0
 * <p>
 * aabbcd
 * Sample Output 0
 * <p>
 * NO
 * Explanation 0
 * <p>
 * Given , we would need to remove two characters, both c and d  aabb or a and b  abcd, to make it valid. We are limited to removing only one character, so  is invalid.
 * <p>
 * Sample Input 1
 * <p>
 * aabbccddeefghi
 * Sample Output 1
 * <p>
 * NO
 * Explanation 1
 * <p>
 * Frequency counts for the letters are as follows:
 * <p>
 * {'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}
 * <p>
 * There are two ways to make the valid string:
 * <p>
 * Remove  characters with a frequency of : .
 * Remove  characters of frequency : .
 * Neither of these is an option.
 * <p>
 * Sample Input 2
 * <p>
 * abcdefghhgfedecba
 * Sample Output 2
 * <p>
 * YES
 * Explanation 2
 * <p>
 * All characters occur twice except for  which occurs  times. We can delete one instance of  to have a valid string.
 *
 * @author shakil akhtar
 */
public class SherlockAndValidString {

    static String isValid(String s) {
        String res = "";
        //Take two maps 1 for storing char and other for occurrence
        Map<Character, Integer> charFreq = new HashMap<>();
        Map<Integer, Integer> freqOccurrence = new HashMap<>();
        char[] arr = s.toCharArray();
        int foccr = 0;
        for (int i = 0; i < arr.length; i++) {
            int freq = charFreq.getOrDefault(arr[i], 0);
            foccr = freqOccurrence.getOrDefault(freq, 0);
            if (foccr > 0) {
                if (foccr - 1 == 0) {
                    freqOccurrence.remove(freq);
                } else {
                    freqOccurrence.put(freq, foccr - 1);
                }
            }
            freq++;
            charFreq.put(arr[i], freq);
            foccr = freqOccurrence.getOrDefault(freq, 0);
            freqOccurrence.put(freq, foccr + 1);
        }
        Set<Integer> keyset = freqOccurrence.keySet();
        int max = keyset.stream().max(Comparator.naturalOrder()).get();
        int min = keyset.stream().min(Comparator.naturalOrder()).get();
        //Case 1
        if (s.length() == 1 || max - min == 0) {
            res = "YES";
        } else if (keyset.size() < 3 && (max - min == 1 && freqOccurrence.get(max) == 1)
                || (min == 1 && freqOccurrence.get(min) == 1)
                && !(freqOccurrence.get(min) == 1 && freqOccurrence.get(max) == 1)) { // case 2

            res = "YES";
        } else {
            res = "NO";
        }

        return res;
    }

    public static void main(String[] args) {

        String s = "xxxaabbccrry";
        System.out.println(isValid(s));
    }
}

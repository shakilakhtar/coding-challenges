package com.challenge.leetcode;

import java.util.Arrays;
/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * @author Shakil Akhtar
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        char[] cs1=s.toCharArray();
        char [] cs2=t.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        String sn1=new String(cs1);
        String sn2=new String(cs2);
        if(sn1.equals(sn2)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        String s = "rat", t = "car";
        System.out.println(isAnagram(s,t));
    }
}

package com.challenge.hackerrank.interviewprepkit.strings;

import java.util.*;

public class MakingAnagrams {

    static int makeAnagram(String a, String b) {
        int[] letterCounts = new int[26];
        for(char c : a.toCharArray()){
            letterCounts[c-'a']++;
        }
        for(char c : b.toCharArray()){
            letterCounts[c-'a']--;
        }
        int result = 0;
        for(int i : letterCounts){
            result += Math.abs(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "acde";
        String b = "aabc";
        int count = makeAnagram(a, b);
        System.out.println(count);
    }
}

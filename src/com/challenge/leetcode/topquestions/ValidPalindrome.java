package com.challenge.leetcode.topquestions;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (end >= start) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (end > start && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s ="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}

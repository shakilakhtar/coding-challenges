package com.challenge.hackerrank.interviewprepkit.strings;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        char[] carr = s.toCharArray();
        int deleteCount = 0;
        for (int i = 0; i < carr.length-1; i++) {
            if (carr[i] == carr[i + 1]) {
                deleteCount++;
            }
        }
        return deleteCount;
    }

    public static void main(String[] args) {
        String s = "ABABABAB";
        int c = alternatingCharacters(s);
        System.out.println(c);
    }
}

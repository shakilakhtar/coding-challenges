package com.challenge.hackerrank.warmup;

import java.util.Arrays;
/**
 * @author Shakil Akhtar
 */
public class Staircase {

    // Complete the staircase function below.

    static void staircase(int n) {
        for (int i=1;i<=n;i++){
             String s1=repeat(' ',n-i);
             String s2=repeat('#',i);
             System.out.println(s1+s2);
         }

    }

    public static String repeat(char what, int howmany) {
        char[] chars = new char[howmany];
        Arrays.fill(chars, what);
        return new String(chars);
    }
    public static void main(String[] args) {
        staircase(4);
    }
}

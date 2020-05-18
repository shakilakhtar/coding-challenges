package com.challenge.leetcode;
/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * @author Shakil Akhtar
 */
public class ReverseString {

    public static void reverseString(char[] s) {
     int back=s.length-1;
     for(int forward=0;forward<=Math.ceil(s.length/2);forward++,back--){
         if(forward<back) {
             //swap elements
             char temp = s[forward];
             s[forward] = s[back];
             s[back] = temp;
         }
     }
     //print string
        for(char c:s){
            System.out.print(c+", ");
        }

    }

    public static void main(String[] args) {
         char[] s = {'H','a','n','n','a','h'};//{'h','e','l','l','o'};
        reverseString(s);
    }
}

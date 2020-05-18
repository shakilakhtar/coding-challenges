package com.challenge.leetcode;

import java.math.BigInteger;
import java.util.stream.IntStream;
/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * @author Shakil Akhtar
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        if(digits.length==0){
            return digits;
        }
         int firstElement =digits[0];
        int res[]=plusRec(digits,digits.length-1);
        int[] expand=res;
        if(firstElement==9 && res[0]==0){
            // array needs to be expanded
           expand = new int[res.length+1];
            expand[0]=1;
            for(int i=0;i<res.length;i++){
                expand[i+1]=res[i];
            }
        }
       return expand;
    }
    static int[] plusRec(int digits[], int n){
        int i=n;
        if(i<0) {
            return digits;
        }
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
            i--;
        return plusRec(digits,i);
    }

    public static void main(String[] args) {

        int[] a={9,9,9};
        int[] res=plusOne(a);
        for (int i:res){
            System.out.print(i+" ");
        }
    }
}

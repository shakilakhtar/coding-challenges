package com.challenge.hackerrank.interviewprepkit.recursionandbacktracking;

/**
 * The Fibonacci Sequence
 * <p>
 * The Fibonacci sequence appears in nature all around us, in the arrangement of seeds in a sunflower and the spiral of a nautilus for example.
 * <p>
 * The Fibonacci sequence begins with  and  as its first and second terms. After these first two elements, each subsequent element is equal to the sum of the previous two elements.
 * <p>
 * Programmatically:
 * <p>
 * Given , return the  number in the sequence.
 * <p>
 * As an example, . The Fibonacci sequence to  is . With zero-based indexing, .
 * <p>
 * Function Description
 * <p>
 * Complete the recursive function  in the editor below. It must return the  element in the Fibonacci sequence.
 * <p>
 * fibonacci has the following parameter(s):
 * <p>
 * n: the integer index of the sequence to return
 * Input Format
 * <p>
 * The input line contains a single integer, .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Locked stub code in the editor prints the integer value returned by the  function.
 * <p>
 * Sample Input
 * <p>
 * 3
 * Sample Output
 * <p>
 * 2
 * Explanation
 * <p>
 * The Fibonacci sequence begins as follows:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * ...
 * <p>
 * We want to know the value of . In the sequence above,  evaluates to .
 */
public class FibonacciNumbers {

    public static int fibonacci(int n) {
        return n < 2 ? n : fibonacci(n-1) + fibonacci(n-2);

    }

    public static void main(String[] args) {
        int n = 3;
        int num = fibonacci(3);
        System.out.println(num);
    }
}

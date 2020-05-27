package com.challenge.hackerrank.interviewprepkit.arrays;

/**
 * A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .
 *
 * Given an array  of  integers and a number, , perform  left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.
 *
 * @author shakil akhtar
 */
public class ArraysLeftRotation {

    // Complete the rotLeft function below.
    static int[] rotateLeft(int[] a, int d) {

        for (int j = 0; j < d; j++) {

            int temp = a[0];

            for (int i = 0; i < a.length - 1; i++) {
                a[i] = a[i + 1];
            }
            a[a.length - 1] = temp;
        }
        return a;
    }

    static void printArray(int[] a) {
        System.out.println();
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int d = 4;
        rotateLeft(a, d);
        printArray(a);
    }

}

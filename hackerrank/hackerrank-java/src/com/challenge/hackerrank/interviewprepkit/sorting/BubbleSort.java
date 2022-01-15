package com.challenge.hackerrank.interviewprepkit.sorting;

/**
 * Consider the following version of Bubble Sort:
 * <p>
 * for (int i = 0; i < n; i++) {
 * <p>
 * for (int j = 0; j < n - 1; j++) {
 * // Swap adjacent elements if they are in decreasing order
 * if (a[j] > a[j + 1]) {
 * swap(a[j], a[j + 1]);
 * }
 * }
 * <p>
 * }
 * Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm above. Once sorted, print the following three lines:
 * <p>
 * Array is sorted in numSwaps swaps., where  is the number of swaps that took place.
 * First Element: firstElement, where  is the first element in the sorted array.
 * Last Element: lastElement, where  is the last element in the sorted array.
 * Hint: To complete this challenge, you must add a variable that keeps a running tally of all swaps that occur during execution.
 * <p>
 * For example, given a worst-case but small array to sort:  we go through the following steps:
 * <p>
 * swap    a
 * 0       [6,4,1]
 * 1       [4,6,1]
 * 2       [4,1,6]
 * 3       [1,4,6]
 * It took  swaps to sort the array. Output would be
 * <p>
 * Array is sorted in 3 swaps.
 * First Element: 1
 * Last Element: 6
 * Function Description
 * <p>
 * Complete the function countSwaps in the editor below. It should print the three lines required, then return.
 * <p>
 * countSwaps has the following parameter(s):
 * <p>
 * a: an array of integers .
 * Input Format
 * <p>
 * The first line contains an integer, , the size of the array .
 * The second line contains  space-separated integers .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * You must print the following three lines of output:
 * <p>
 * Array is sorted in numSwaps swaps., where  is the number of swaps that took place.
 * First Element: firstElement, where  is the first element in the sorted array.
 * Last Element: lastElement, where  is the last element in the sorted array.
 * Sample Input 0
 * <p>
 * 3
 * 1 2 3
 * Sample Output 0
 * <p>
 * Array is sorted in 0 swaps.
 * First Element: 1
 * Last Element: 3
 * Explanation 0
 * The array is already sorted, so  swaps take place and we print the necessary three lines of output shown above.
 *
 * @author shakil akhtar
 */
public class BubbleSort {


    static void countSwaps(int[] a) {
        int swapCount = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapCount++;
                }
            }

        }


        System.out.print("Array is sorted in " + swapCount + " swaps.\n");

        System.out.print("First Element: " + a[0] + "\n");

        System.out.print("Last Element: " + a[n - 1]);
    }


    public static void main(String[] args) {

        int[] a = {3, 2, 1};

        countSwaps(a);
    }
}

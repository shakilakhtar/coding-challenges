package com.challenge.hackerrank.interviewprepkit.sorting;

/**
 * In an array, , the elements at indices  and  (where ) form an inversion if . In other words, inverted elements  and  are considered to be "out of order". To correct an inversion, we can swap adjacent elements.
 *
 * For example, consider the dataset . It has two inversions:  and . To sort the array, we must perform the following two swaps to correct the inversions:
 *
 * Given  datasets, print the number of inversions that must be swapped to sort each dataset on a new line.
 *
 * Function Description
 *
 * Complete the function countInversions in the editor below. It must return an integer representing the number of inversions required to sort the array.
 *
 * countInversions has the following parameter(s):
 *
 * arr: an array of integers to sort .
 * Input Format
 *
 * The first line contains an integer, , the number of datasets.
 *
 * Each of the next  pairs of lines is as follows:
 *
 * The first line contains an integer, , the number of elements in .
 * The second line contains  space-separated integers, .
 * Constraints
 *
 * Output Format
 *
 * For each of the  datasets, return the number of inversions that must be swapped to sort the dataset.
 *
 * Sample Input
 *
 * 2
 * 5
 * 1 1 1 2 2
 * 5
 * 2 1 3 1 2
 * Sample Output
 *
 * 0
 * 4
 * Explanation
 *
 * We sort the following  datasets:
 *
 *  is already sorted, so there are no inversions for us to correct. Thus, we print  on a new line.
 * We performed a total of  swaps to correct inversions.
 *
 * @author shakil akhtar
 *
 */
public class CountingInversions {
    static long countInversions(int[] arr) {

        long inversionsCount = 0;

        int[] lowerArray = new int[arr.length];
        int[] higherArray = new int[arr.length]; //frm mid+1 to high


        inversionsCount = countAndSort(arr, 0, arr.length - 1, lowerArray, higherArray);
        return inversionsCount;
    }

    static long countAndSort(int[] arr, int low, int high, int[] lowerArray, int[] higherArray) {
        long totalCount = 0;
        long count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;

            long lowerCount = countAndSort(arr, low, mid, lowerArray, higherArray);
            long higherCount = countAndSort(arr, mid + 1, high, lowerArray, higherArray);
            totalCount += lowerCount + higherCount + countAndSortMerge(arr, low, mid, high, lowerArray, higherArray);
        }

        return totalCount;
    }

    static long countAndSortMerge(int[] arr, int low, int mid, int high, int[] lowerArray, int[] higherArray) {
        long countInversions = 0;

        for (int i = 0; i < (mid - low + 1); i++) {
            lowerArray[i] = arr[low + i];
        }

        for (int i = 0; i < (high - mid); i++) {
            higherArray[i] = arr[mid + 1 + i];
        }

        int lowIndex = 0;
        int highIndex = 0;
        int arrIndex = low;

        while (lowIndex < (mid - low + 1) && highIndex < (high - mid)) {
            if (lowerArray[lowIndex] <= higherArray[highIndex]) {
                arr[arrIndex] = lowerArray[lowIndex];

                ++lowIndex;
            } else {
                arr[arrIndex] = higherArray[highIndex];

                ++highIndex;
                countInversions += (mid - low + 1 - lowIndex);
            }

            ++arrIndex;
        }


        while (lowIndex < (mid - low + 1)) {
            arr[arrIndex] = lowerArray[lowIndex];

            ++lowIndex;
            ++arrIndex;
        }

        while (highIndex < (high - mid)) {
            arr[arrIndex] = higherArray[highIndex];

            ++highIndex;
            ++arrIndex;
        }

        return countInversions;

    }

    public static void main(String[] args) {

    }
}

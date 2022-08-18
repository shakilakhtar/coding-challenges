package com.challenge.leetcode.sorting;

/**
 * 912. Sort an Array
 *
 *Given an array of integers nums, sort the array in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        sort(nums);
        return nums;
    }

    public static void  buildHeap(int[] array, int n){
        for (int i = n/2-1; i >= 0; i--) {
            heapify(array, n, i);
        }
    }

    public static void sort(int[] array){
        int n = array.length;
        buildHeap(array,n);

        for (int i = n-1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }
    public static void heapify(int[] array, int n, int idx){
        int largest = idx;
        int l =  2*idx +1;
        int r = 2*idx+2;

        if (l < n && array[l] > array[largest]){
            largest = l;
        }
        if (r < n && array[r] > array[largest]){
            largest = r;
        }

        if (largest != idx){
            int swap = array[idx];
            array[idx] = array[largest];
            array[largest] = swap;

            heapify(array,n,largest);
        }
    }
}

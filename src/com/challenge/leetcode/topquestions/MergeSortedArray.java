package com.challenge.leetcode;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 * @author Shakil Akhtar on 18/12/19
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i= m-1;
        int j= n-1;
        for(int s1 = nums1.length-1; s1>=0; s1--){
            if(i < 0 || (j>= 0 && nums2[j] > nums1[i])){
                nums1[s1] = nums2[j--];
            }
            else if(j < 0 || (i >=0 && nums2[j] <= nums1[i])){
                nums1[s1] = nums1[i--];
            }
        }

            System.out.println(nums1);
    }

    public static void main(String[] args) {
        //as per problem statement num1 is always greater and can hold other array elements
        int [] num1={1,2,3,0,0,0};int m=3;
        int [] num2={2,5,6};int n=3;
        merge(num1,m,num2,n);
        System.out.println();
    }
}

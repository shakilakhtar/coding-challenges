package com.challenge.leetcode.topquestions;


import java.util.ArrayList;
import java.util.List;
/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * @author Shakil Akhtar
 */
public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        int l1= nums1.length;
        int l2= nums2.length;
        int biggerLength;
        int smallerLength;
        int[] bigArray;
        int[] smallArray;
        if(l1<=l2){
            biggerLength=l2;
            smallerLength=l1;
            bigArray=nums2;
            smallArray=nums1;
        }
        else{
            biggerLength=l1;
            smallerLength=l2;
            bigArray=nums1;
            smallArray=nums2;
        }
        List<Integer> result=new ArrayList<>();
        if(smallArray.length>0) {
            //get first element matching index in searching array
            int index = -1;
            for (int j = 0; j <= biggerLength; j++) {
                if (bigArray[j] == smallArray[0]) {
                    //first element match
                    index = j;
                    break;
                }
            }
            if (index >= 0) {
                int cur = 0;
                for (int i = index, j = 0; j < smallerLength; i++, j++) {
                    if(i<biggerLength) {
                        if (smallArray[j] == bigArray[i]) {
                            result.add(smallArray[j]);
                        }
                    }
                }
            }
        }
        int[] returnArray = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return returnArray;
    }

    public static void main(String[] args) {

        int[] nums1 = {2,1}; int[] nums2 = {1,1};
        int[] a= intersect(nums1,nums2);
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}

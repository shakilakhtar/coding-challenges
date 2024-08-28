package arrays.faqs.hard;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int left = m - 1;
        int right =  0;

        while (left >=0 && right < n){
            if (nums1[left] > nums2[right]) {
                //swap
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            }
            else {
                break;
            }
        }
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);
        //put elements of num2 in mum1
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
    }
    public static void main(String[] args) {

    }
}

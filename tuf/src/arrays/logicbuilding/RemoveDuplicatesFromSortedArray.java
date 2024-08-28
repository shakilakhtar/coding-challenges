package arrays.logicbuilding;

/**
 * Remove duplicates from sorted array
 * 100 points
 *
 *
 * 21
 *
 * Given an integer array nums sorted in non-decreasing order, remove all duplicates in-place so that each unique element appears only once. Return the number of unique elements in the array.
 *
 *
 *
 * If the number of unique elements be k, then,
 *
 * Change the array nums such that the first k elements of nums contain the unique values in the order that they were present originally.
 * The remaining elements, as well as the size of the array does not matter in terms of correctness.
 *
 *
 * An array sorted in non-decreasing order is an array where every element to the right of an element in either equal to or greater in value than that element.
 *
 *
 * Example 1
 * Input: nums = [0, 0, 3, 3, 5, 6]
 *
 * Output: [0, 3, 5, 6, _, _]
 *
 * Explanation: There are 4 distinct elements in nums and the elements marked as _ can have any value.
 *
 * Example 2
 * Input: nums = [-2, 2, 4, 4, 4, 4, 5, 5]
 *
 * Output: [-2, 2, 4, 5, _, _, _, _]
 *
 * Explanation: There are 4 distinct elements in nums and the elements marked as _ can have any value.
 *
 * Example 3
 * Input: nums = [-30, -30, 0, 0, 10, 20, 30, 30]
 *
 * Output :
 *
 * Submit
 * Note: Fill the answer in the same format as in Example 1 and 2, make sure to add commas, and spaces.
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int uniqueIdx = 0;
        for (int i = 0; i <nums.length ; i++) {
         if (nums[i] != nums[uniqueIdx]){
             nums[uniqueIdx + 1] = nums[i];
             uniqueIdx++;
         }
        }
        return uniqueIdx + 1;
    }
    public static void main(String[] args) {
        int [] a = {0, 0, 3, 3, 5, 6};
        removeDuplicates(a);
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] +" ");
        }
    }
}

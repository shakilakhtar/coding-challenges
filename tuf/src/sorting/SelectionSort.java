package sorting;

/**
 * Given an array of integers nums, sort the array in non-decreasing order using the selection sort algorithm and return the sorted array.
 *
 *
 *
 * A sorted array in non-decreasing order is an array where each element is greater than or equal to all previous elements in the array.
 *
 *
 * Example 1
 * Input: nums = [7, 4, 1, 5, 3]
 *
 * Output: [1, 3, 4, 5, 7]
 *
 * Explanation: 1 <= 3 <= 4 <= 5 <= 7.
 *
 * Thus the array is sorted in non-decreasing order.
 *
 * Example 2
 * Input: nums = [5, 4, 4, 1, 1]
 *
 * Output: [1, 1, 4, 4, 5]
 *
 * Explanation: 1 <= 1 <= 4 <= 4 <= 5.
 *
 * Thus the array is sorted in non-decreasing order.
 *
 * Example 3
 * Input: nums = [3, 2, 3, 4, 5]
 *
 * Output :
 *
 * Submit
 * Note: Fill the answer in the same format as in Example 1 and 2, make sure to add commas, and spaces.
 * Constraints:
 * 1 <= nums.length <= 1000
 * -104 <= nums[i] <= 104
 * nums[i] may contain duplicate values.
 */
public class SelectionSort {
    public static int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1 ; i++) {
            int minIdx = i;
            for (int j = i; j <= nums.length -1 ; j++) {
                //get the min
                if (nums[j] < nums[minIdx]){
                    minIdx = j;
                }

            }
            //place min in th ith position
             int temp = nums[minIdx];
             nums[minIdx] = nums[i];
             nums[i] = temp;

        }

        return nums;
    }

    public static void main(String[] args) {

        int [] a = {7, 4, 1, 5, 3};
        selectionSort(a);
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] +" ");
        }
    }
}

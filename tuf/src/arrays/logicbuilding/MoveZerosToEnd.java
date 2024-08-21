package arrays.logicbuilding;

/**
 * Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements must remain the same. This must be done in place, without making a copy of the array.
 *
 *
 * Example 1
 * Input: nums = [0, 1, 4, 0, 5, 2]
 *
 * Output: [1, 4, 5, 2, 0, 0]
 *
 * Explanation: Both the zeroes are moved to the end and the order of the other elements stay the same
 *
 * Example 2
 * Input: nums = [0, 0, 0, 1, 3, -2]
 *
 * Output: [1, 3, -2, 0, 0, 0]
 *
 * Explanation: All 3 zeroes are moved to the end and the order of the other elements stay the same
 *
 * Example 3
 * Input: nums = [0, 20, 0, -20, 0, 20]
 *
 * Output :
 * 20,-20,20,0,0,0
 * Correct Answer: [20, -20, 20, 0, 0, 0]
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <=nums[i] <= 104
 */
public class MoveZerosToEnd {
    public static void moveZeroes(int[] nums) {
         int lastZeroIdx = -1;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == 0){
                lastZeroIdx = i;
                break;
            }
        }
        if (lastZeroIdx == -1) return;
        for (int i = lastZeroIdx + 1; i <nums.length ; i++) {
            if (nums[i] != 0){
                //swap i with j
                int temp  = nums[i];
                nums[i] = nums[lastZeroIdx];
                nums[lastZeroIdx] = temp;
                lastZeroIdx++;
            }
        }
    }
    public static void main(String[] args) {
        int [] a = {0, 1, 4, 0, 5, 2};
        moveZeroes(a);
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] +" ");
        }
    }
}

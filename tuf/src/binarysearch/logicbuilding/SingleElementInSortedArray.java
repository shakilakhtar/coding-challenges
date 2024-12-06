package binarysearch.logicbuilding;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        // set low and high to 1 and size -2 to avoid
        //many conditional statements
        int n = nums.length;
        int low = 1;
        int high = n - 2;

        //edge cases
        if (n == 1) return nums[0];
        //check if first element is single
        if (nums[0] != nums[1]){
            return nums[0];
        }
        //check if last element is single
        if (nums[n - 1] != nums[n - 2]){
            return nums[n - 1];
        }

        while (low <= high){
         int mid = (low + high)/2;
         //if mid is the single element
            if (nums[mid] != nums[mid +1] && nums[mid] != nums[mid -1]){
                return nums[mid];
            }
            //we are in the left part
            //eliminate left part (even, odd) (odd,even) indexes
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1])
            || (mid % 2 == 0 && nums[mid] == nums[mid + 1])){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}

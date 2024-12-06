package binarysearch.logicbuilding;

public class SearchInRotatedSortedArray1 {
    public int search(int[] nums, int k) {

        int low= 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid =  (low + high)/2;
            if (nums[mid] == k) {
                return mid;
            }
            //check if left part is sorted
            if (nums[low] <= nums[mid]){
                if (nums[low] <= k && k <= nums[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else { //check if right part is sorted
                if (nums[mid] <= k && k <= nums[high]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}

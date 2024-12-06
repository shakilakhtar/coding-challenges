package binarysearch.logicbuilding;

public class FirstAndLastOccurrence {
    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums,target);
        if(lb == nums.length || nums[lb]!= target){
            return new int[]{-1, -1};
        }
        int ub = upperBound(nums,target);
        return new int[]{lb, ub - 1};
    }

    public int lowerBound(int[] nums, int x) {
        int low = 0;
        int high =  nums.length - 1;

        int lowerBoundIdx = nums.length;

        while (low <= high){
            int mid = (low + high)/2;

            if (nums[mid] >= x){
                lowerBoundIdx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return lowerBoundIdx;
    }
    public int upperBound(int[] nums, int x) {
        int low = 0;
        int high =  nums.length - 1;
        int upperBoundIdx = nums.length;

        while (low <= high){
            int mid = (low + high)/2;

            if (nums[mid] > x){
                upperBoundIdx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return upperBoundIdx;
    }
    public static void main(String[] args) {

    }
}

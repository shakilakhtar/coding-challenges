package binarysearch.fundamentals;

public class UpperBound {
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

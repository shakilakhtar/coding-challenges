package binarysearch.fundamentals;

public class LowerBound {
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
    public static void main(String[] args) {

    }
}

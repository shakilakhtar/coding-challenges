package binarysearch.logicbuilding;

import java.util.ArrayList;

public class FindOutHowManyTimesArrayIsRotated {
    public int findKRotation(ArrayList<Integer> nums) {
        int low = 0;
        int high = nums.size() - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high){
            int mid =  (low + high)/2;
            /* Search space is already sorted
               then nums.get(low) will always be
               the minimum in that search space */
            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < min) {
                    index = low;
                    min = nums.get(low);
                }
                break;
            }
            if (nums.get(low) <= nums.get(mid)){
                if (nums.get(low) < min) {
                    min = nums.get(low);
                    index = low;
                }
                low = mid + 1;
            }else {
                if (nums.get(mid) < min) {
                    min = nums.get(mid);
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }
    public static void main(String[] args) {

    }
}

package binarysearch.logicbuilding;

import java.util.ArrayList;

public class SearchInRotatedSortedArray2 {
    public boolean searchInARotatedSortedArrayII(ArrayList<Integer> nums, int k) {
        {
            int low= 0;
            int high = nums.size() - 1;

            while (low <= high){
                int mid =  (low + high)/2;
                if (nums.get(mid) == k) {
                    return true;
                }
                //t duplicate check condition
                if (nums.get(low) == nums.get(mid) && nums.get(mid) == nums.get(high)){
                    //shrink search space
                    low = low + 1;
                    high = high - 1;
                    continue;
                }
                //check if left part is sorted
                if (nums.get(low) <= nums.get(mid)){
                    if (nums.get(low) <= k && k <= nums.get(mid)){
                        high = mid - 1;
                    }else {
                        low = mid + 1;
                    }
                }else { //check if right part is sorted
                    if (nums.get(mid) <= k && k <= nums.get(high)){
                        low = mid + 1;
                    }else {
                        high = mid - 1;
                    }
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {

    }
}

package binarysearch.logicbuilding;

public class FloorAndCeilInSortedArray {
    public int[] getFloorAndCeil(int[] nums, int x) {
       int floor = getFloor(nums, x);
       int ceil = getCeil(nums, x);

       return new int[]{floor, ceil};
    }

    public int getFloor(int[] nums, int x){
        int low = 0;
        int high =  nums.length - 1;

        int floor = -1;

        while (low <= high){
            int mid = (low + high)/2;

            if (nums[mid] <= x){
                floor = nums[mid];
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return floor;
    }

    public int getCeil(int[] nums, int x){
        int low = 0;
        int high =  nums.length - 1;

        int ceil = -1;

        while (low <= high){
            int mid = (low + high)/2;

            if (nums[mid] >= x){
                ceil = nums[mid];
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ceil;
    }
    public static void main(String[] args) {

    }
}

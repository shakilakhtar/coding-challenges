package arrays.fundamentals;

import java.util.Arrays;

public class SecondLargestElement {
    public static int secondLargestElement(int[] nums) {
        Arrays.sort(nums);
        int largest =  nums[nums.length - 1];
        int secondLargest =  -1;
        for (int i = nums.length - 1; i >=0 ; i--) {
            if (largest > nums[i]){
                secondLargest = nums[i];
                break;
            }
        }
        return secondLargest;
    }
    public static void main(String[] args) {
        int [] a = {8, 8, 7, 6, 5};
        int sl = secondLargestElement(a);
        System.out.println(sl);

    }
}

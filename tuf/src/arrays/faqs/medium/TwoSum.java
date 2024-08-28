package arrays.faqs.medium;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
         int[] res =  new int[2];
        //sort the array
        Arrays.sort(nums);
        int ptr1 =  0;
        int ptr2 =  nums.length - 1;
        while  (ptr1 < ptr2) {
            if (nums[ptr1] + nums[ptr2] > target){
                ptr2--;
            }
            else if (nums[ptr1] + nums[ptr2] < target){
                ptr1++;
            }
            else {
                if(nums[ptr1] + nums[ptr2] < target) {
                    res[0] = ptr1;
                    res[1] = ptr2;
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int [] a = {1, 6, 2, 10, 3};
        int[] result = twoSum(a, 7);
        for (int i = 0; i < result.length ; i++) {
            System.out.print(a[i] +" ");
        }
    }
}

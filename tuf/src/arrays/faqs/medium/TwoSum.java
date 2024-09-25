package arrays.faqs.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target  - nums[i];
            if (map.containsKey(rem)){

                return new int[]{map.get(i), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }
    public static int[] twoSum2(int[] nums, int target) {
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
                if(nums[ptr1] + nums[ptr2] == target) {
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
        int[] result = twoSum2(a, 7);
        for (int i = 0; i < result.length ; i++) {
            System.out.print(a[i] +" ");
        }
    }
}

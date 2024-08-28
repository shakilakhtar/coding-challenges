package arrays.faqs.medium;

public class RearrangeArrayElementsBySign {
    public static int[] rearrangeArray(int[] nums) {
        int [] arr =  new int[nums.length];
        int positiveIdx = 0;
        int negativeIdx = 1;
        for (int i = 0; i < nums.length ; i++) {
             if (nums[i] < 0){
                 arr[negativeIdx] = nums[i];
                 negativeIdx = negativeIdx + 2;
             }else {
                 arr[positiveIdx] = nums[i];
                 positiveIdx = positiveIdx + 2;
             }
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] a = {2, 4, 5, -1, -3, -4};
        int [] res = rearrangeArray(a);
        for (int i = 0; i < res.length ; i++) {
            System.out.print(res[i] +" ");
        }
    }
}

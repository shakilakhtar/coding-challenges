package arrays.faqs.medium;

public class MaxSubArrayKadaneAlgo {

    // Kadane's algorithms for max sum subarray;
    public static int maxSubArray(int[] nums) {
      long maxSum =  Long.MIN_VALUE;
       int sum =  0;
        for (int i = 0; i <nums.length ; i++) {
            sum = sum +nums[i];

            if (sum > maxSum){
                maxSum = sum;
            }
            if (sum < 0){
                sum =0;
            }
        }
        return (int)maxSum;
    }

    public static void main(String[] args) {
        int [] a = {2, 3, 5, -2, 7, -4};
        int maxSubArraySum = maxSubArray(a);
        System.out.print(maxSubArraySum);
    }
}

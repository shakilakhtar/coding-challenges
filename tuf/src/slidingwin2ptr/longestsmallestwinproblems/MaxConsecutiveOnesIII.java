package slidingwin2ptr.longestsmallestwinproblems;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int len  = nums.length;
        //add window left and right
        int left = 0;
        int right = 0;
        int maxLength = 0 ;
        //variable to count zeros
        int zeros = 0;

        while (right < len){

            if (nums[right] == 0){
                zeros++;
            }
            if (zeros > k){
                if (nums[left] == 0){
                    zeros--;
                }
                left++;
            }
            if (zeros <= k){
                int length = right - left + 1;
                maxLength = Math.max(length, maxLength);
            }
            right++;
        }
        return maxLength;
    }
    public static void main(String[] args) {

    }
}

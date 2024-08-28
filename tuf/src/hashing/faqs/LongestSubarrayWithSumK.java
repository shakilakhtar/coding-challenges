package hashing.faqs;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        int sum = 0;
        Map<Integer,Integer> preSumMap =  new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum == k){
                maxLength = Math.max(maxLength, i + 1);
            }

            int remainingPart = sum - k;
            if (preSumMap.containsKey(remainingPart)){
                int len  = i - preSumMap.get(remainingPart);
                maxLength = Math.max(maxLength, len);
            }
            if (!preSumMap.containsKey(sum)){
                preSumMap.put(sum, i);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {

    }
}

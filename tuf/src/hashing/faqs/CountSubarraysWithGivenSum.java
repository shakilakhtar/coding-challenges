package hashing.faqs;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenSum {
    public int subarraySum(int[] nums, int k) {

        int subarrayCount =  0;
        int currentPrefixSum =0;
        Map<Integer, Integer> prefixSumMap =  new HashMap<>();
        prefixSumMap.put(0,1);

        for (int i = 0; i <nums.length ; i++) {
            currentPrefixSum += nums[i];
            int remainPart =  currentPrefixSum - k;
            subarrayCount+= prefixSumMap.getOrDefault(remainPart,0);
            prefixSumMap.put(currentPrefixSum,prefixSumMap.getOrDefault(currentPrefixSum,0)+1);
        }
      return subarrayCount;
    }
    public static void main(String[] args) {

    }
}

package hashing.faqs;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenXorK {
    public int subarraysWithXorK(int[] nums, int k) {

        int subarrayCount = 0;
        int xor = 0;
        Map<Integer,Integer> xorMap =  new HashMap<>();
        xorMap.put(xor, xorMap.getOrDefault(xor,0)+1);

        for (int i = 0; i <nums.length ; i++) {
            //prefix xor till index
            xor = xor ^ nums[i];
            //by formula x = xor ^ k
            int x = xor ^ k;
            subarrayCount+= xorMap.getOrDefault(x, 0);
            //insert prefix xor till index i
            xorMap.put(xor,xorMap.getOrDefault(xor ,0) +1);
        }
        return subarrayCount;
    }
    public static void main(String[] args) {

    }
}

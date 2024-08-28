package hashing.faqs;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceInAnArray {
    public int longestConsecutive(int[] nums) {
        int n =  nums.length;
        //check empty array
        if (n == 0) return 0;

        int longestSeq = 1;
        Set<Integer> s = new HashSet<>();
        //add all elements in the set
        for (int i = 0; i <n ; i++) {
            s.add(nums[i]);
        }
        //get the longest sequence
        for (int e: s) {
            if (!s.contains(e - 1)){
                int count = 1;
                //get the starting element of the sequence
                int x = e;

                //find consecutive numbers in the sequence
                while (s.contains(x + 1)){
                    x = x + 1;
                    count = count + 1;
                }
                //update longest sequence
                longestSeq = Math.max(longestSeq, count);
            }
        }
        return longestSeq;
    }
    public static void main(String[] args) {

    }
}

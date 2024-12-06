package slidingwin2ptr.longestsmallestwinproblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int longestNonRepeatingSubstring(String s) {
        int len = s.length();
       int[] hash = new int[256];
       // fill hash with -1
        Arrays.fill(hash,-1);
        int l = 0;
        int r = 0;
        int maxLength = 0;
        while (r < len){
            //If current character s.charAt(r)is already in the substring
            char c =  s.charAt(r);
            if (hash[c] != -1){
                //Move left pointer to the right
                // of the last occurrence of s.charAt(r)
                l = Math.max(hash[c] + 1, l);
            }
            // Calculate the current substring length
            int subStringLen = r - l + 1;
            // Update maximum length found so far
            maxLength = Math.max(maxLength,subStringLen);
            //Store the index of the current character in the hash table
            hash[c] = r;
            // Move right pointer to next position
            r++;
        }

        return maxLength;
    }
    public static void main(String[] args) {

    }
}

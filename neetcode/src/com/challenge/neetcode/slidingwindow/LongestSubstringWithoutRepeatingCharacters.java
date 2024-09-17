package com.challenge.neetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        List<Character> substringL =  new ArrayList<>();
       int largestLength = 0;
       for (int right = 0; right < s.length(); right++){
           if (substringL.contains(s.charAt(right))){
               //get the index of character
               int index = substringL.indexOf(s.charAt(right));
               substringL.remove(index);
               if (index > 0){
                   substringL.subList(0,index).clear();
               }
           }
           substringL.add(s.charAt(right));
           largestLength = Math.max(largestLength,substringL.size());
       }
       return largestLength;
    }
}

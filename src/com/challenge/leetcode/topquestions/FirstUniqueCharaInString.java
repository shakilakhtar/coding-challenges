package com.challenge.leetcode.topquestions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * @author Shakil Akhtar
 */
public class FirstUniqueCharaInString {

    public static int firstUniqChar(String s) {
        //take storage to keep letter and its frequency
        Map<Character,Integer> map = new HashMap<>();
        char[] carray=s.toCharArray();
        for(char c:carray){
            if(map.containsKey(c)) {
                int freq=map.get(c);
                map.put(c, freq+1);
            }
            else {
                map.put(c, 1);
            }
        }
        for (int i=0;i<carray.length;i++){
            if(map.containsKey(carray[i])){
                int freq=map.get(carray[i]);
                if(freq==1){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        int index=firstUniqChar(s);
        System.out.println(index);
    }
}

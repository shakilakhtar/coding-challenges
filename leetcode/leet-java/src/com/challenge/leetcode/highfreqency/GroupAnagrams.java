package com.challenge.leetcode.highfreqency;

import java.util.*;

/**
 * 49. Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List<String>> map =  new HashMap<>();
          if(strs!=null && strs.length == 0){
              return new ArrayList<>();
          }
        for(String s: strs){
            //sort the string
            int[] count =  new int[26];
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int j=0; j< 26; j++){
                sb.append(count[j]);
                sb.append("#"); // add seperator for edge case where key might be same
            }
            String key =sb.toString();
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);

        }
          return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map =  new HashMap<>();
        if(strs!=null && strs.length == 0){
            return new ArrayList<>();
        }
        for(int i=0;i<strs.length; i++){
            //sort the string
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr =String.valueOf(chars);
            if(map.containsKey(sortedStr)){
                map.get(sortedStr).add(strs[i]);
            }else {
                ArrayList<String> list= new ArrayList<>();
                list.add(strs[i]);
                map.put(sortedStr,list);
            }
        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
    }
}

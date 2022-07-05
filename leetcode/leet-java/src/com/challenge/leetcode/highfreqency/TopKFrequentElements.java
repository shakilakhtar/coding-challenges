package com.challenge.leetcode.highfreqency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length) return nums;
        Map<Integer,Integer> count  = new HashMap<>();
        for (int num:nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        List<Integer>[] buckets =  new List[nums.length+1];
        for (int i=0; i< buckets.length;i++){
            buckets[i] = new ArrayList<>();
        }
        for (int key: count.keySet()){
            buckets[count.get(key)].add(key);
        }
        List<Integer> flattened =  new ArrayList<>();
        for (int i=buckets.length-1;i>=0; i--){
            for (int num : buckets[i]){
                flattened.add(num);
            }
        }
        int[] top = new int[k];
        for (int i=0; i< k;i++){
            top[i] = flattened.get(i);
        }
        return top;
    }
}

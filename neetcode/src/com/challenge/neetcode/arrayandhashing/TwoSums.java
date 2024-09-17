package com.challenge.neetcode.arrayandhashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    public static int[] TwoSums(int[] arr, int sum){
        Map<Integer,Integer> map =  new HashMap<>();
        for (int i = 0; i < arr.length ; i++) {
            int target = sum - arr[i];
            if (map.containsKey(target)){
                return new int[]{arr[i],target};
            }
                map.put(arr[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{1,2,2,4,5,8};
        int[] result = TwoSums(arr,4);
        System.out.println(result[0] +" " + result[1]);
    }
}

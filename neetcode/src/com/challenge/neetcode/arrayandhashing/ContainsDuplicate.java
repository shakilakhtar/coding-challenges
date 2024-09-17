package com.challenge.neetcode.arrayandhashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean ContainsDuplicateInArray(int[] n){
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i <n.length ; i++) {
            if (set.contains(n[i])){
                return true;
            }
            set.add(n[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{1,2,2,4,5,8};
        boolean result = ContainsDuplicateInArray(arr);
        System.out.println(result);

    }
}

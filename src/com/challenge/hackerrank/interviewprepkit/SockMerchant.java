package com.challenge.hackerrank.interviewprepkit;

import java.util.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        Map<Integer, Integer> pairMap = new HashMap<>();
        int pairs = 0;
        for (int i = 0; i < ar.length; i++) {
            if (pairMap.containsKey(ar[i])) {
                int value = pairMap.get(ar[i]);
                pairMap.put(ar[i], value + 1);
            } else {
                pairMap.put(ar[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : pairMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
            pairs = pairs + entry.getValue() / 2;
        }


        return pairs;
    }

    public static void main(String[] args) {
        int a[] = {10, 20, 30};
        int n = 3;
        int pairs = sockMerchant(n, a);


    }
}

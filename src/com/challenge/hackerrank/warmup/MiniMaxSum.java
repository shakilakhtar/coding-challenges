package com.challenge.hackerrank.warmup;

import java.util.Arrays;
/**
 * @author Shakil Akhtar
 */
public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        //minimum sum
        long min=0;
        long max=0;

        for (int i=0; i<arr.length;i++){
            if(i>3) {
              break;
            }
            min += arr[i];
            //maximum sum
            max+=arr[arr.length-i-1];

        }
        System.out.println(min+" "+max);
    }

    public static void main(String[] args) {

        int [] a ={1, 2, 3, 4, 5};
        miniMaxSum(a);
    }
}

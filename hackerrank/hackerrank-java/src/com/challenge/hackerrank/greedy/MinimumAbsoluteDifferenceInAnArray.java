package com.challenge.hackerrank.greedy;

import java.util.Arrays;

/**
 * @author Shakil Akhtar on 18/12/19
 */
public class MinimumAbsoluteDifferenceInAnArray {
    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
      int minAbsDiff = 0;
        Arrays.sort(arr);
        if(arr.length==1){
            minAbsDiff=Math.abs(arr[0]);
        }
        if(arr.length>=2){
            minAbsDiff=Math.abs(arr[0]-arr[1]);
        }
      for(int i=0;i<arr.length;i++){
          if(i+1<arr.length) {
              int absDiff = Math.abs(arr[i]-arr[i+1]);
              if(absDiff<minAbsDiff){
                  minAbsDiff = absDiff;
              }
          }

      }
      return minAbsDiff;
    }
    public static void main(String[] args) {
         int [] a={-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
         int minDiff = minimumAbsoluteDifference(a);
         System.out.println(minDiff);
    }
}

package com.challenge.hackerrank.warmup;

import java.util.Arrays;
/**
 * @author Shakil Akhtar
 */
public class BirthdayCakeCandles {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        Arrays.sort(ar);
        int max=ar[ar.length-1];
        int total=0;
        for (int i=ar.length-1;i>=0;i--){
            if(ar[i]==max){
                total+=1;
            }
            else{
                break;
            }
        }
        return total;
    }

    public static void main(String[] args) {

        int [] a ={3, 2, 1,3};
        int candlesBlown=birthdayCakeCandles(a);
        System.out.println(candlesBlown);
    }
}

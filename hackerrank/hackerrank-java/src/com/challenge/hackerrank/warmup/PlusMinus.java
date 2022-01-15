package com.challenge.hackerrank.warmup;

/**
 * @author Shakil Akhtar
 */
public class PlusMinus {
    public static void main(String[] args) {

        int[] a={-4, 3, -9, 0, 4, 1,};
        plusMinus(a);
        System.out.println();
    }

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double positiveCount=0;
        double negativeCount =0;
        double zerosCount=0;
       for (int i=0;i<arr.length;i++){

           if(arr[i]==0){
               zerosCount+=1;
           }
           else if (arr[i]>0){
               positiveCount+=1;
           }
           else {
               negativeCount+=1;
           }
       }

       //Ratios
        double posRatio= positiveCount/arr.length;
        double negRatio=negativeCount/arr.length;
        double zeroRatio=zerosCount/arr.length;

        System.out.printf("%.6f %n",posRatio);
        System.out.printf("%.6f %n",negRatio);
        System.out.printf("%.6f %n",zeroRatio);


    }
}

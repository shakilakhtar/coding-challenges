package com.challenge.hackerrank.greedy;

import java.util.Arrays;

/**
 * Marc loves cupcakes, but he also likes to stay fit. Each cupcake has a calorie count, and Marc can walk a distance to expend those calories. If Marc has eaten  cupcakes so far, after eating a cupcake with  calories he must walk at least  miles to maintain his weight.
 *
 * For example, if he eats  cupcakes with calorie counts in the following order: , the miles he will need to walk are . This is not the minimum, though, so we need to test other orders of consumption. In this case, our minimum miles is calculated as .
 *
 * Given the individual calorie counts for each of the cupcakes, determine the minimum number of miles Marc must walk to maintain his weight. Note that he can eat the cupcakes in any order.
 *
 * Function Description
 *
 * Complete the marcsCakewalk function in the editor below. It should return a long integer that represents the minimum miles necessary.
 *
 * marcsCakewalk has the following parameter(s):
 *
 * calorie: an integer array that represents calorie count for each cupcake
 * Input Format
 *
 * The first line contains an integer , the number of cupcakes in .
 * The second line contains  space-separated integers .
 *
 * Constraints
 *
 * Output Format
 *
 * Print a long integer denoting the minimum number of miles Marc must walk to maintain his weight.
 *
 * Sample Input 0
 *
 * 3
 * 1 3 2
 * Sample Output 0
 *
 * 11
 * Explanation 0
 *
 * Let's say the number of miles Marc must walk to maintain his weight is . He can minimize  by eating the  cupcakes in the following order:
 *
 * Eat the cupcake with  calories, so .
 * Eat the cupcake with  calories, so .
 * Eat the cupcake with  calories, so .
 * We then print the final value of , which is , as our answer.
 *
 * @author Shakil Akhtar on 18/12/19
 */
public class MarcsCakewalk {
    // Complete the marcsCakewalk function below.
    static long marcsCakewalk(int[] calorie) {
        Arrays.sort(calorie);
        double total=0;
        int n=calorie.length-1;
        for(int j=n;j>=0;j--){
            total=total+calorie[j]*Math.pow(2,n-j);
        }

        return (long) total;
    }
    public static void main(String[] args) {

        int [] cal = {1,3,2};
        long l = marcsCakewalk(cal);
        System.out.println(l);
    }
}

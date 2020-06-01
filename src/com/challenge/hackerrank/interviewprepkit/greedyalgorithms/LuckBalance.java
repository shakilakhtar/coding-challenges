package com.challenge.hackerrank.interviewprepkit.greedyalgorithms;

import java.util.*;

/**
 * Lena is preparing for an important coding competition that is preceded by a number of sequential preliminary contests. Initially, her luck balance is 0. She believes in "saving luck", and wants to check her theory. Each contest is described by two integers,  and :
 * <p>
 * is the amount of luck associated with a contest. If Lena wins the contest, her luck balance will decrease by ; if she loses it, her luck balance will increase by .
 * denotes the contest's importance rating. It's equal to  if the contest is important, and it's equal to  if it's unimportant.
 * If Lena loses no more than  important contests, what is the maximum amount of luck she can have after competing in all the preliminary contests? This value may be negative.
 * <p>
 * For example,  and:
 * <p>
 * Contest		L[i]	T[i]
 * 1		5	1
 * 2		1	1
 * 3		4	0
 * If Lena loses all of the contests, her will be . Since she is allowed to lose  important contests, and there are only  important contests. She can lose all three contests to maximize her luck at . If , she has to win at least  of the  important contests. She would choose to win the lowest value important contest worth . Her final luck will be .
 * <p>
 * Function Description
 * <p>
 * Complete the luckBalance function in the editor below. It should return an integer that represents the maximum luck balance achievable.
 * <p>
 * luckBalance has the following parameter(s):
 * <p>
 * k: the number of important contests Lena can lose
 * contests: a 2D array of integers where each  contains two integers that represent the luck balance and importance of the  contest.
 * Input Format
 * <p>
 * The first line contains two space-separated integers  and , the number of preliminary contests and the maximum number of important contests Lena can lose.
 * Each of the next  lines contains two space-separated integers,  and , the contest's luck balance and its importance rating.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print a single integer denoting the maximum amount of luck Lena can have after all the contests.
 * <p>
 * Sample Input
 * <p>
 * 6 3
 * 5 1
 * 2 1
 * 1 1
 * 8 1
 * 10 0
 * 5 0
 * Sample Output
 * <p>
 * 29
 * Explanation
 * <p>
 * There are  contests. Of these contests,  are important and she cannot lose more than  of them. Lena maximizes her luck if she wins the  important contest (where ) and loses all of the other five contests for a total luck balance of .
 *
 * @author shakil akhtar
 */
public class LuckBalance {

    static int luckBalance(int k, int[][] contests) {
        //int[] store = new int[contests.length];
        List<Integer> store = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < contests.length; i++) {
            int[] row = contests[i];
            if (row[1] == 1) {
                store.add(row[0]);
                // store[i] = row[0];
            }
            sum += row[0];
        }
        Collections.sort(store);
        int totalImp = store.size();
//        Arrays.sort(store);
//        int totalImp = store.length;
        //can not loose more than k
        //how many to win
        int win = totalImp - k;
        for (int j = 0; j < win; j++) {
            sum = sum - 2 * store.get(j);
//            sum = sum - 2 * store[j];
        }

        return sum;
    }

    public static void main(String[] args) {
        int m[][] = {{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}};

        int luck = luckBalance(3, m);
        System.out.println(luck);
    }
}

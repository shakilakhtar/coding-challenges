package com.challenge.hackerrank.interviewprepkit.recursionandbacktracking;

import java.util.*;

/**
 * Davis has a number of staircases in his house and he likes to climb each staircase , , or  steps at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.
 * <p>
 * Given the respective heights for each of the  staircases in his house, find and print the number of ways he can climb each staircase, module  on a new line.
 * <p>
 * For example, there is  staircase in the house that is  steps high. Davis can step on the following sequences of steps:
 * <p>
 * 1 1 1 1 1
 * 1 1 1 2
 * 1 1 2 1
 * 1 2 1 1
 * 2 1 1 1
 * 1 2 2
 * 2 2 1
 * 2 1 2
 * 1 1 3
 * 1 3 1
 * 3 1 1
 * 2 3
 * 3 2
 * There are  possible ways he can take these  steps.
 * <p>
 * Function Description
 * <p>
 * Complete the stepPerms function in the editor below. It should recursively calculate and return the integer number of ways Davis can climb the staircase, modulo 10000000007.
 * <p>
 * stepPerms has the following parameter(s):
 * <p>
 * n: an integer, the number of stairs in the staircase
 * Input Format
 * <p>
 * The first line contains a single integer, , the number of staircases in his house.
 * Each of the following  lines contains a single integer, , the height of staircase .
 * <p>
 * Constraints
 * <p>
 * Subtasks
 * <p>
 * for  of the maximum score.
 * Output Format
 * <p>
 * For each staircase, return the number of ways Davis can climb it as an integer.
 * <p>
 * Sample Input
 * <p>
 * 3
 * 1
 * 3
 * 7
 * Sample Output
 * <p>
 * 1
 * 4
 * 44
 * Explanation
 * <p>
 * Let's calculate the number of ways of climbing the first two of the Davis'  staircases:
 * <p>
 * The first staircase only has  step, so there is only one way for him to climb it (i.e., by jumping  step). Thus, we print  on a new line.
 * The second staircase has  steps and he can climb it in any of the four following ways:
 * Thus, we print  on a new line.
 */
public class DavisStaircase {
    static Map<Integer, Integer> memoriseMap = new HashMap<>();

    static int stepPerms(int n) {

        //use memorization
        memoriseMap.put(1, 1);
        memoriseMap.put(2, 2);
        memoriseMap.put(3, 4);
        if (memoriseMap.containsKey(n)) {
            return memoriseMap.get(n);
        }

        int result = stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3);
        memoriseMap.put(n, result);
        return memoriseMap.get(n);
    }

    static int stepPermsRecurssion(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        return stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3);

    }

    public static void main(String[] args) {
        int n = 7;
        int nways = stepPerms(n);
        System.out.println(nways);
    }
}

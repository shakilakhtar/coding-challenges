package com.challenge.hackerrank.interviewprepkit.search;

import java.util.*;

/**
 * You are planning production for an order. You have a number of machines that each have a fixed number of days to produce an item. Given that all the machines operate simultaneously, determine the minimum number of days to produce the required order.
 * <p>
 * For example, you have to produce  items. You have three machines that take  days to produce an item. The following is a schedule of items produced:
 * <p>
 * Day Production  Count
 * 2   2               2
 * 3   1               3
 * 4   2               5
 * 6   3               8
 * 8   2              10
 * It takes  days to produce  items using these machines.
 * <p>
 * Function Description
 * <p>
 * Complete the minimumTime function in the editor below. It should return an integer representing the minimum number of days required to complete the order.
 * <p>
 * minimumTime has the following parameter(s):
 * <p>
 * machines: an array of integers representing days to produce one item per machine
 * goal: an integer, the number of items required to complete the order
 * Input Format
 * <p>
 * The first line consist of two integers  and , the size of  and the target production.
 * The next line contains  space-separated integers, .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Return the minimum time required to produce  items considering all machines work simultaneously.
 * <p>
 * Sample Input 0
 * <p>
 * 2 5
 * 2 3
 * Sample Output 0
 * <p>
 * 6
 * Explanation 0
 * <p>
 * In  days  can produce  items and  can produce  items. This totals up to .
 * <p>
 * Sample Input 1
 * <p>
 * 3 10
 * 1 3 4
 * Sample Output 1
 * <p>
 * 7
 * Explanation 1
 * <p>
 * In  minutes,  can produce  items,  can produce  items and  can produce  item, which totals up to .
 * <p>
 * Sample Input 2
 * <p>
 * 3 12
 * 4 5 6
 * Sample Output 2
 * <p>
 * 20
 * Explanation 2
 * <p>
 * In  days  can produce  items,  can produce , and  can produce .
 */
public class MinimumTimeRequired {


    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long max = machines[machines.length - 1];
        long minDays = 0;
        long maxDays = max * goal;
        long result = -1;
        while (minDays < maxDays) {
            long mid = (minDays + maxDays) / 2;
            long unit = 0;
            for (long machine : machines) {
                unit += mid / machine;
            }
            if (unit < goal) {
                minDays = mid + 1;
            } else {
                result = mid;
                maxDays = mid;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        long[] machines = {1, 3, 4};
        long goal = 10;
        long minDays = minTime(machines, goal);
        System.out.println(minDays);
    }
}

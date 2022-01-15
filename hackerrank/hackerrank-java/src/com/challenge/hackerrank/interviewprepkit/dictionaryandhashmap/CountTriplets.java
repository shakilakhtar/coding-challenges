package com.challenge.hackerrank.interviewprepkit.dictionaryandhashmap;

import java.util.*;

/**
 * You are given an array and you need to find number of tripets of indices  such that the elements at those indices are in geometric progression for a given common ratio  and .
 *
 * For example, . If , we have  and  at indices  and .
 *
 * Function Description
 *
 * Complete the countTriplets function in the editor below. It should return the number of triplets forming a geometric progression for a given  as an integer.
 *
 * countTriplets has the following parameter(s):
 *
 * arr: an array of integers
 * r: an integer, the common ratio
 * Input Format
 *
 * The first line contains two space-separated integers  and , the size of  and the common ratio.
 * The next line contains  space-seperated integers .
 *
 * Constraints
 *
 * Output Format
 *
 * Return the count of triplets that form a geometric progression.
 *
 * Sample Input 0
 *
 * 4 2
 * 1 2 2 4
 * Sample Output 0
 *
 * 2
 * Explanation 0
 *
 * There are  triplets in satisfying our criteria, whose indices are  and
 *
 * Sample Input 1
 *
 * 6 3
 * 1 3 9 9 27 81
 * Sample Output 1
 *
 * 6
 * Explanation 1
 *
 * The triplets satisfying are index , , , ,  and .
 *
 * Sample Input 2
 *
 * 5 5
 * 1 5 5 25 125
 * Sample Output 2
 *
 * 4
 * Explanation 2
 *
 * The triplets satisfying are index , , , .
 *
 * @author shakil akhtar
 *
 */
public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {
        // take right map
        Map<Long, Long> rightMap = new HashMap<>();
        Map<Long, Long> leftMap = new HashMap<>();
        //add elements and frequency in right map
        arr.forEach(e -> {
            rightMap.put(e, rightMap.getOrDefault(e, 0L) + 1);
        });

        //traverse array start right side is your right map and left side left map
        // this is used for maintaining indexes.Consider a/r a ar terms as progression
        long totalTriplets = 0;
        for (int i = 0; i < arr.size(); i++) {
            long midTerm = arr.get(i);
            long c1 = 0, c3 = 0;
            rightMap.put(midTerm, rightMap.getOrDefault(midTerm, 0L) - 1);
            if (leftMap.containsKey(midTerm / r) && midTerm % r == 0) {
                c1 = leftMap.get(midTerm / r);
            }

            if (rightMap.containsKey(midTerm * r)) {
                c3 = rightMap.get(midTerm * r);
            }

            totalTriplets += c1 * c3;

            leftMap.put(midTerm, leftMap.getOrDefault(midTerm, 0L) + 1);
        }


        return totalTriplets;
    }

    public static void main(String[] args) {

    }
}

package com.challenge.hackerrank.interviewprepkit.search;

import java.util.*;

/**
 * Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool their money to buy ice cream. On any given day, the parlor offers a line of flavors. Each flavor has a cost associated with it.
 * <p>
 * Given the value of  and the  of each flavor for  trips to the Ice Cream Parlor, help Sunny and Johnny choose two distinct flavors such that they spend their entire pool of money during each visit. ID numbers are the 1- based index number associated with a . For each trip to the parlor, print the ID numbers for the two types of ice cream that Sunny and Johnny purchase as two space-separated integers on a new line. You must print the smaller ID first and the larger ID second.
 * <p>
 * For example, there are  flavors having . Together they have  to spend. They would purchase flavor ID's  and  for a cost of . Use  based indexing for your response.
 * <p>
 * Note:
 * <p>
 * Two ice creams having unique IDs  and  may have the same cost (i.e., ).
 * There will always be a unique solution.
 * Function Description
 * <p>
 * Complete the function whatFlavors in the editor below. It must determine the two flavors they will purchase and print them as two space-separated integers on a line.
 * <p>
 * whatFlavors has the following parameter(s):
 * <p>
 * cost: an array of integers representing price for a flavor
 * money: an integer representing the amount of money they have to spend
 * Input Format
 * <p>
 * The first line contains an integer, , the number of trips to the ice cream parlor.
 * <p>
 * Each of the next  sets of  lines is as follows:
 * <p>
 * The first line contains .
 * The second line contains an integer, , the size of the array .
 * The third line contains  space-separated integers denoting the .
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print two space-separated integers denoting the respective indices for the two distinct flavors they choose to purchase in ascending order. Recall that each ice cream flavor has a unique ID number in the inclusive range from  to .
 * <p>
 * Sample Input
 * <p>
 * 2
 * 4
 * 5
 * 1 4 5 3 2
 * 4
 * 4
 * 2 2 4 3
 * Sample Output
 * <p>
 * 1 4
 * 1 2
 * Explanation
 * <p>
 * Sunny and Johnny make the following two trips to the parlor:
 * <p>
 * The first time, they pool together  dollars. There are five flavors available that day and flavors  and  have a total cost of .
 * The second time, they pool together  dollars. There are four flavors available that day and flavors  and  have a total cost of .
 *
 * @author shakil akhtar
 */
public class IceCreamParlor {

    static void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> map = new HashMap<>();
        int complement = money - cost[0];
        map.put(complement, 1);
        for (int i = 1; i < cost.length; i++) {
            if (map.containsKey(cost[i])) {
                System.out.println(map.get(cost[i]) + " " + (i + 1));

            } else {
                if (!map.containsKey(cost[i]) && money - cost[i] > 0) {
                    map.put(money - cost[i], i + 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        int money = 6;
        int[] cost = {1, 4, 5, 3, 2};
        whatFlavors(cost, money);
    }
}

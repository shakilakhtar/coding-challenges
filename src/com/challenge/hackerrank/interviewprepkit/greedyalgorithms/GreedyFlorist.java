package com.challenge.hackerrank.interviewprepkit.greedyalgorithms;

import java.util.*;

public class GreedyFlorist {
    static int getMinimumCost(int k, int[] c) {
        // Convert the array to List.
        List<Integer> costs = new ArrayList<Integer>();
        for (int index = 0; index < c.length; index++) {
            costs.add(c[index]);
        }
        // Sort in Descending Order.
        Collections.sort(costs, Collections.reverseOrder());

        // Previous Flower Count
        int prev = -1;
        // Cost
        int cost = 0;

        int size = costs.size();
        int i = 0;
        for (Integer flowerCost : costs) {
            // Increase the Previous
            if (i % k == 0) {
                ++prev;
            }
            cost += (flowerCost * (prev + 1));
            ++i;
        }

        return cost;

    }

    public static void main(String[] args) {

        int[] c = new int[]{2, 5, 6,};
        int k = 2;
        int minCost = getMinimumCost(k, c);
        System.out.println(minCost);
    }


}

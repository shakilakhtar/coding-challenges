package com.challenge.careercup;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Given multiple input streams of sorted numbers of infinite size, produce a single sorted output stream.
 *
 * (The size of all the input streams are unknown)
 *
 * For eg.
 *
 * Input Stream 1: 2,4,5,6,7,8...........
 * Input Stream 2: 1,3,9,12..............
 * Input Stream 3: 10,11,13,14........
 *
 * Output Stream:
 * 1,2,3,4,5,6,7,8,9,10,11,12,13...............
 */
public class MergeNumStreams {

    private static int[] mergeStreams(int[][] is) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < is.length; i++) {
            for (int j = 0; j < is[i].length; j++)
                pq.add(is[i][j]);
        }
        int[] result = new int[pq.size()];
        int counter = 0;
        Iterator<Integer> i = pq.iterator();
        while (i.hasNext()) {
            result[counter++] = pq.remove();
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeStreams(
                new int[][] { { 2, 4, 5, 6, 7, 8 },
                        { 1, 3, 9, 12 },
                        { 10, 11, 13, 14 } })));
    }
}

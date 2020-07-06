package com.challenge.geeksforgeek.heap;

import java.util.*;

public class MergeKSortedArrays {

    static class Triplets implements Comparable<Triplets> {

        int val;
        int aPosition;
        int vPosition;

        public Triplets(int val, int aPosition, int vPosition) {
            this.val = val;
            this.aPosition = aPosition;
            this.vPosition = vPosition;
        }

        @Override
        public int compareTo(Triplets t) {
            if (val <= t.val) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static List<Integer> mergeArrays(List<List<Integer>> arr) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Triplets> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.size(); i++) {
            pq.add(new Triplets(arr.get(i).get(0), i, 0));

        }

        while (pq.isEmpty() == false) {
            Triplets curr = pq.poll();
            res.add(curr.val);
            int ap = curr.aPosition, vp = curr.vPosition;
            if (vp + 1 < arr.get(ap).size()) {
                pq.add(new Triplets(arr.get(ap).get(vp + 1), ap, vp + 1));

            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<>();
        a1.add(5);
        a1.add(6);
        List<Integer> a2 = new ArrayList<>();
        a2.add(3);
        a2.add(4);
        List<Integer> a3 = new ArrayList<>();
        a3.add(2);

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(a1);
        arr.add(a2);
        arr.add(a3);
        List<Integer> res = mergeArrays(arr);
        res.forEach(i -> System.out.print(i + " "));
    }
}

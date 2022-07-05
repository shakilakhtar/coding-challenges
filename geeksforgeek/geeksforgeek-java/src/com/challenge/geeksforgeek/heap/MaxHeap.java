package com.challenge.geeksforgeek.heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //add elements to the min heap
        pq.add(10);
        pq.add(5);
        pq.add(15);
        pq.add(5);

        //operations on priority queue
        System.out.println("size "+pq.size());
        System.out.println("peek "+pq.peek());
        System.out.println("poll "+pq.poll());
        System.out.println("size "+pq.size());


    }
}

package com.challenge.hackerrank.interviewprepkit.stacksandqueues;

import java.util.*;

/**
 * A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.
 * <p>
 * A basic queue has the following operations:
 * <p>
 * Enqueue: add a new element to the end of the queue.
 * Dequeue: remove the element from the front of the queue and return it.
 * In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:
 * <p>
 * 1 x: Enqueue element  into the end of the queue.
 * 2: Dequeue the element at the front of the queue.
 * 3: Print the element at the front of the queue.
 * For example, a series of queries might be as follows:
 * <p>
 * image
 * <p>
 * Function Description
 * <p>
 * Complete the put, pop, and peek methods in the editor below. They must perform the actions as described above.
 * <p>
 * Input Format
 * <p>
 * The first line contains a single integer, , the number of queries.
 * <p>
 * Each of the next  lines contains a single query in the form described in the problem statement above. All queries start with an integer denoting the query , but only query  is followed by an additional space-separated value, , denoting the value to be enqueued.
 * <p>
 * Constraints
 * <p>
 * It is guaranteed that a valid answer always exists for each query of types  and .
 * Output Format
 * <p>
 * For each query of type , return the value of the element at the front of the fifo queue on a new line.
 * <p>
 * Sample Input
 * <p>
 * 10
 * 1 42
 * 2
 * 1 14
 * 3
 * 1 28
 * 3
 * 1 60
 * 1 78
 * 2
 * 2
 * Sample Output
 * <p>
 * 14
 * 14
 * Explanation
 * <p>
 * image
 *
 * @author shakil akhtar
 */
public class QueueATaleOfTwoStacks {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) {
            if (stackNewestOnTop.isEmpty()) {
                stackNewestOnTop.push(value);
                return;
            }
            stackOldestOnTop.push(value);
        }

        public T peek() {
            return stackNewestOnTop.peek();
        }

        public T dequeue() {
            T item = stackNewestOnTop.pop();
            if (stackNewestOnTop.isEmpty()) {
                while (!stackOldestOnTop.isEmpty()) {
                    stackNewestOnTop.push(stackOldestOnTop.pop());
                }
            }
            return item;
        }
    }


    public static void main(String[] args) {

    }
}


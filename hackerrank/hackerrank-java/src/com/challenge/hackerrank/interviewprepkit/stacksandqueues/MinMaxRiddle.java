package com.challenge.hackerrank.interviewprepkit.stacksandqueues;

import java.util.*;

/**
 * Given an integer array of size , find the maximum of the minimum(s) of every window size in the array. The window size varies from  to .
 *
 * For example, given , consider window sizes of  through . Windows of size  are . The maximum value of the minimum values of these windows is . Windows of size  are  and their minima are . The maximum of these values is . Continue this process through window size  to finally consider the entire array. All of the answers are .
 *
 * Function Description
 *
 * Complete the riddle function in the editor below. It must return an array of integers representing the maximum minimum value for each window size from  to .
 *
 * riddle has the following parameter(s):
 *
 * arr: an array of integers
 * Input Format
 *
 * The first line contains a single integer, , the size of .
 * The second line contains  space-separated integers, each an .
 *
 * Constraints
 *
 *
 *
 * Output Format
 *
 * Single line containing  space-separated integers denoting the output for each window size from  to .
 *
 * Sample Input 0
 *
 * 4
 * 2 6 1 12
 * Sample Output 0
 *
 * 12 2 1 1
 * Explanation 0
 *
 * Here  and
 *
 * window size	window1	window2	window3	window4	maximum of all windows
 * 1	2	6	1	12	12
 * 2	2	1	1		2
 * 3	1	1			1
 * 4	1				1
 * Sample Input 1
 *
 * 7
 * 1 2 3 5 1 13 3
 * Sample Output 1
 *
 * 13 3 2 1 1 1 1
 * Explanation 1
 *
 * Here  and
 *
 * win size	w_1	w_2	w_3	w_4	w_5	w_6	w_7	maximum of all windows
 * 1	1	2	3	5	1	13	3	13
 * 2	1	2	3	1	1	3		3
 * 3	1	2	1	1	1			2
 * 4	1	1	1	1				1
 * 5	1	1	1					1
 * 6	1	1						1
 * 7	1							1
 * Sample Input 2
 *
 * 6
 * 3 5 4 7 6 2
 * Sample Output 2
 *
 * 7 6 4 4 3 2
 * Explanation 2
 *
 * Here  and
 *
 * win size	w_1	w_2	w_3	w_4	w_5	w_6	maximum of all windows
 * 1	3	5	4	7	6	2	7
 * 2	3	4	4	6	2		6
 * 3	3	4	4	2			4
 * 4	3	4	2				4
 * 5	3	2					3
 * 6	2						2
 *
 */
public class MinMaxRiddle {
    static long[] riddle(long[] arr) {
        long[] ans = new long[arr.length];
        Map<Integer, Long> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < arr.length; i++) {
            while (stack.peek() != -1 && arr[stack.peek()] > arr[i]) {
                int val = stack.pop();
                int key = i - stack.peek() - 1;
                map.put(key, Math.max(arr[val], map.getOrDefault(key, 0L)));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int val = stack.pop();
            int key = arr.length - stack.peek() - 1;
            map.put(key, Math.max(arr[val], map.getOrDefault(key, 0L)));
        }
        long last = 0;
        List<Long> list = new ArrayList<>();
        for (int size = arr.length; size >= 1; size--) {
            if (map.containsKey(size)) {
                last = Math.max(last, map.get(size));
            }
            list.add(last);
        }

        int inx = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            ans[inx++] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

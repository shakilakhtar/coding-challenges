package com.challenge.matrix;

import java.util.*;

public class MaximumRectangularSubmatrixOf1s {

    public static int largestArea(List<List<Integer>> samples) {
        // Write your code here
        int[][] matrix = new int[samples.size()][samples.size()];
        for (int i = 0; i < samples.size(); i++) {
            List<Integer> r = samples.get(i);
            for (int j = 0; j < r.size(); j++) {
                matrix[i][j] = r.get(j);
            }
        }
        return maximumArea(matrix);
    }

    public static int maximumArea(int matrix[][]) {
        int temp[] = new int[matrix[0].length];
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (matrix[i][j] == 0) {
                    temp[j] = 0;
                } else {
                    temp[j] += matrix[i][j];
                }
            }
            area = maxAreaRow(temp);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static int maxAreaRow(int row[]) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for (i = 0; i < row.length; ) {
            if (stack.isEmpty() || row[stack.peekFirst()] <= row[i]) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                if (stack.isEmpty()) {
                    area = row[top] * i;
                } else {
                    area = row[top] * (i - stack.peekFirst() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pollFirst();
            if (stack.isEmpty()) {
                area = row[top] * i;
            } else {
                area = row[top] * (i - stack.peekFirst() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String args[]) {
        int input[][] = {{1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};
        MaximumRectangularSubmatrixOf1s mrs = new MaximumRectangularSubmatrixOf1s();
        int maxRectangle = mrs.maximumArea(input);
        System.out.println("Max rectangle is of size " + maxRectangle);
        //assert maxRectangle == 8;
    }

    //   class MaximumHistogram {

    //   }


}

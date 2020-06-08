package com.challenge.hackerrank.interviewprepkit.stacksandqueues;

import java.util.*;

/**
 * You are given a square grid with some cells open (.) and some blocked (X). Your playing piece can move along any row or column until it reaches the edge of the grid or a blocked cell. Given a grid, a start and an end position, determine the number of moves it will take to get to the end position.
 * <p>
 * For example, you are given a grid with sides  described as follows:
 * <p>
 * ...
 * .X.
 * ...
 * Your starting position  so you start in the top left corner. The ending position is . The path is . It takes  moves to get to the goal.
 * <p>
 * Function Description
 * Complete the minimumMoves function in the editor. It must print an integer denoting the minimum moves required to get from the starting position to the goal.
 * <p>
 * minimumMoves has the following parameter(s):
 * <p>
 * grid: an array of strings representing the rows of the grid
 * startX: an integer
 * startY: an integer
 * goalX: an integer
 * goalY: an integer
 * Input Format
 * <p>
 * The first line contains an integer , the size of the array grid.
 * Each of the next  lines contains a string of length .
 * The last line contains four space-separated integers,
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print an integer denoting the minimum number of steps required to move the castle to the goal position.
 * <p>
 * Sample Input
 * <p>
 * 3
 * .X.
 * .X.
 * ...
 * 0 0 0 2
 * Sample Output
 * <p>
 * 3
 * Explanation
 * <p>
 * Here is a path that one could follow in order to reach the destination in  steps:
 * <p>
 * .
 */
public class CastleOnTheGrid {

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

        ArrayDeque<Position> queue = new ArrayDeque<Position>();

        int matrix[][] = new int[grid.length][grid.length];

        for (int i = 0; i < grid.length; i++) {
            String curr = grid[i];
            for (int j = 0; j < curr.length(); j++) {
                matrix[i][j] = curr.charAt(j) == '.' ? 1 : -1;
            }
        }

        Position pos = new Position(startX, startY, 0);
        queue.offer(pos);

        while (!queue.isEmpty()) {

            Position current = queue.poll();

            if (current.row == goalX && current.col == goalY) {
                return current.number;
            }

            matrix[current.row][current.col] = 0;

            addMoves(queue, current, matrix);
        }

        return -1;
    }

    static void addMoves(Queue<Position> queue, Position current, int[][] matrix) {

        int row = current.row;
        int col = current.col;
        int number = current.number + 1;

        // Go top

        while (--row >= 0 && matrix[row][col] == 1) {
            queue.offer(new Position(row, col, number));
        }

        // Go down
        row = current.row;
        col = current.col;

        while (++row < matrix.length && matrix[row][col] == 1) {
            queue.offer(new Position(row, col, number));
        }

        // Go left
        row = current.row;
        col = current.col;

        while (--col >= 0 && matrix[row][col] == 1) {
            queue.offer(new Position(row, col, number));
        }

        // Go right
        row = current.row;
        col = current.col;

        while (++col < matrix.length && matrix[row][col] == 1) {
            queue.offer(new Position(row, col, number));
        }


    }

    static class Position {
        int row;
        int col;
        int number;

        public Position(int row, int col, int number) {
            this.row = row;
            this.col = col;
            this.number = number;
        }
    }


    public static void main(String[] args) {

    }
}

package com.challenge.leetcode.highfreqency;

/**
 * Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
         int rows = grid.length;
         if(rows == 0){
             return 0;
         }
         int columns =  grid[0].length;
         int [][]dpTable = new int[rows][columns];
        dpTable[0][0] = grid[0][0];
        //fill first row
        for(int i=1;i<columns;i++){
            dpTable[0][i] = dpTable[0][i-1] + grid[0][i];
        }
        //fill first column
        for(int i=1;i<rows;i++){
            dpTable[i][0] = dpTable[i-1][0] + grid[i][0];
        }
        for (int i=1; i<rows;i++){
            for (int j=1; j<columns;j++){
               dpTable[i][j] = grid[i][j] + Math.min(dpTable[i-1][j],dpTable[i][j-1]);
            }
        }
        return dpTable[rows-1][columns-1];
    }
}

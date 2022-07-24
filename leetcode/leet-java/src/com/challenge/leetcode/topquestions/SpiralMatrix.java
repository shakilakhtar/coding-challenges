package com.challenge.leetcode.topquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow=0;
        int endRow = matrix.length-1;
        int startCol= 0;
        int endCol = matrix[0].length-1;
        List<Integer> result = new ArrayList<>();

        while(startRow <=endRow && startCol <= endCol){
            //left to right traverse
            for (int j=startCol; j<=endCol; j++){
                result.add(matrix[startRow][j]);
            }
            if (startRow == endRow){
                break;
            }
            //top to down traverse
            for (int i=startRow+1;i<=endRow;i++){
                result.add(matrix[i][endCol]);
            }
            if (startCol == endCol){
                break;
            }
            //right to left traverse
            for (int j=endCol-1;j>=startCol;j--){
                result.add(matrix[endRow][j]);
            }
            //down to top traverse
            for(int i=endRow-1;i>=startRow+1;i--){
                result.add(matrix[i][startCol]);
            }
            startRow+=1;
            endRow-=1;
            startCol+=1;
            endCol-=1;
        }
        return result;
    }
}

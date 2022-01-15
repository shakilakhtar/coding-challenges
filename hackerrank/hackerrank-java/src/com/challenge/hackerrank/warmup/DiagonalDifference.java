package com.challenge.hackerrank.warmup;

import java.util.List;
/**
 * @author Shakil Akhtar
 */
/*
Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix  is shown below:

1 2 3
4 5 6
9 8 9
The left-to-right diagonal = . The right to left diagonal = . Their absolute difference is .

Function description

Complete the  function in the editor below. It must return an integer representing the absolute diagonal difference.

diagonalDifference takes the following parameter:

arr: an array of integers .
Input Format

The first line contains a single integer, , the number of rows and columns in the matrix .
Each of the next  lines describes a row, , and consists of  space-separated integers .

Constraints

Output Format

Print the absolute difference between the sums of the matrix's two diagonals as a single integer.

Sample Input

3
11 2 4
4 5 6
10 8 -12
Sample Output

15
Explanation

The primary diagonal is:

11
   5
     -12
Sum across the primary diagonal: 11 + 5 - 12 = 4

The secondary diagonal is:

     4
   5
10
Sum across the secondary diagonal: 4 + 5 + 10 = 19
Difference: |4 - 19| = 15
 */
public class DiagonalDifference {
    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int[][] array = new int[arr.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[arr.get(i).size()];
        }
        for(int i=0; i<arr.size(); i++){
            for (int j = 0; j < arr.get(i).size(); j++) {
                array[i][j] = arr.get(i).get(j);
            }
        }

        // loop for sum of diagonals
        //sum left to right
        int sumLeft =0;
        //sum right to left diagonal
        int sumRight =0;
        for(int row=0; row<array.length;row++){
            for (int col=0;col<array.length;col++){
                if(row==col){
                    //collect element and add to sum
                    sumLeft+=array[row][col];
                }

                //row = numberOfRows – column -1  => (row+col =noOfRows-1)
                if (row+col == array.length-1){
                    sumRight+= array[row][col];;
                }
            }
        }

        return Math.abs(sumLeft-sumRight);
    }
}

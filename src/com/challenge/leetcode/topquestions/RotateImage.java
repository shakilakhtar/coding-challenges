package com.challenge.leetcode.topquestions;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * @author Shakil Akhtar
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int maxIdx=n-1;
        for (int i=0;i<n/2;i++){
            //n-i-1 (because they are already swapped.)
            for(int j=i;j<n-i-1;j++){
                //swap element from i=> j and  j=>i
                int temp = matrix[i][j];
                matrix[i][j] = matrix[maxIdx-j][i];
                matrix[maxIdx-j][i] = matrix[maxIdx-i][maxIdx-j];
                matrix[maxIdx-i][maxIdx-j] = matrix[j][maxIdx-i];
                matrix[j][maxIdx-i] = temp;
            }
        }
        //print matrix
        for (int i=0;i<matrix.length;i++){
            System.out.println();
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j] +",");

            }
        }
    }

    public static void main(String[] args) {
        int[][] a={{1,2,3},{4,5,6},{7,8,9}};
        rotate(a);
    }
}

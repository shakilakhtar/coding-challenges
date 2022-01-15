package com.challenge.matrix;

public class MaximumSizeSquareMatrixOf1s {

    // method for Maximum size square sub-matrix with all 1s
    static void printMaxSubSquare(int matrix[][]) {
        int i, j;
        int row = matrix.length;
        int column = matrix[0].length;
        int temp[][] = new int[row][column];

        int maxArea, iMax, jMax;

        /* Set first column of S[][]*/
        for (i = 0; i < row; i++) {
            temp[i][0] = matrix[i][0];
        }

        /* Set first row of S[][]*/
        for (j = 0; j < column; j++) {
            temp[0][j] = matrix[0][j];
        }

        /* Construct other entries of S[][]*/
        for (i = 1; i < row; i++) {
            for (j = 1; j < column; j++) {
                if (matrix[i][j] == 1)
                    temp[i][j] = Math.min(temp[i][j - 1],
                            Math.min(temp[i - 1][j], temp[i - 1][j - 1])) + 1;
                else
                    temp[i][j] = 0;
            }
        }

        /* Find the maximum entry, and indexes of maximum entry
            in S[][] */
        maxArea = temp[0][0];
        iMax = 0;
        jMax = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                if (maxArea < temp[i][j]) {
                    maxArea = temp[i][j];
                    iMax = i;
                    jMax = j;
                }
            }
        }
        System.out.println("Area : " + maxArea);
        System.out.println("Maximum size sub-matrix is: ");
        for (i = iMax; i > iMax - maxArea; i--) {
            for (j = jMax; j > jMax - maxArea; j--) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Driver program
    public static void main(String[] args) {
        int M[][] = {{1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};

        printMaxSubSquare(M);
    }
}

package arrays.faqs.medium;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixInSpiral {
    public List<Integer> spiralOrder(int[][] matrix) {

        //have top, bottom, left and right markers
        //print order right --> bottom, left <-- and top
        int top = 0, left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        //left to right direction is true

        List<Integer> result = new ArrayList<>();
        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            //increase top move to next row
            top++;
            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            // Traverse from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        // Create an instance of the Solution class
        PrintMatrixInSpiral finder = new PrintMatrixInSpiral();

        // Get spiral order using class method
        List<Integer> ans = finder.spiralOrder(mat);

        System.out.print("Elements in spiral order are: ");
        for (int i = 0; i < ans.size(); ++i) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

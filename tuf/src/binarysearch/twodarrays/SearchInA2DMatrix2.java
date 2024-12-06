package binarysearch.twodarrays;

public class SearchInA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;
        int row  =  0;
        int col = m - 1;

        while (row < n && col >= 0){
            // return if target is found
            if (matrix[row][col] == target){
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            }else {
                col --;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}

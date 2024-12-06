package binarysearch.twodarrays;

public class SearchInA2DMatrix {
    public boolean searchMatrix(int[][] mat, int target) {

        int n =  mat.length;
        int m = mat[0].length;

        int low = 0;
        int high =  n * m - 1; //length of hypothetical flatten matrix

        while (low <= high){
            int mid = (low + high)/2;
            int row =  mid / m; // formula to get row index where m is number of
            // elements in row
            int col = mid % m; // formula to get the col index
            if (mat[row][col] == target) {
                return true;
            }else if (mat[row][col] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}

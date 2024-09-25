package arrays.faqs.medium;

public class RotateMatrixBy90Degrees {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        //transpose matrix
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <i ; j++) {
               //swap element from diagonal
               int temp =  matrix[i][j];
               matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        }

        //reverse each row of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n /2; j++) {
              int temp =  matrix[i][j];
              matrix[i][j] = matrix[i][n -1-j];
              matrix[i][n -1-j] = temp;
            }

        }
    }
    public static void main(String[] args) {

    }
}

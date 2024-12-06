package dp.grids;

import java.util.Arrays;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[]  row: dp) {
            Arrays.fill(row, -1);
        }
        return recFunc(m - 1, n - 1, matrix, dp);
    }

    private int recFunc(int i, int j, int[][] matrix, int[][] dp){
        if (i == 0 && j ==0){
            return 1;
        }
        if (i > 0 && j > 0 && matrix[i][j] == 1){
            return 0;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        int up = recFunc(i - 1, j, matrix, dp);
        int left = recFunc(i ,j -1, matrix, dp);
        dp[i][j] = up +  left;
        return dp[i][j];
    }
    public static void main(String[] args) {

    }
}

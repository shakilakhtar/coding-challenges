package dp.grids;

import java.util.Arrays;

public class GridUniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row: dp) {
          Arrays.fill(row,-1);
        }
        return recFunc(m - 1, n - 1,dp);
    }

    private int recFunc(int i, int j, int[][] dp){
        if (i == 0 && j == 0){
            return 1;
        }
        if (i < 0 || j < 0){
            return 0;
        }
        //apply dp memoization
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        int up = recFunc(i - 1, j,dp);
        int left = recFunc(i, j - 1, dp);
        dp[i][j] = up + left;
        return dp[i][j];
    }

    public static void main(String[] args) {

    }
}

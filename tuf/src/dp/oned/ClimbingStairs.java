package dp.oned;

import java.util.Arrays;

public class ClimbingStairs {
    public int climbStairs(int n) {
      int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
      return  dp[n] = funcHelper(n,dp);
    }

    private int funcHelper(int n, int[] dp){
        if (n <= 1){
            return 1;
        }
        if (dp[n] != -1){

            return dp[n];
        }
        dp[n] = funcHelper(n -1, dp) + funcHelper(n -2, dp);
        return dp[n];
    }
    public static void main(String[] args) {

    }
}

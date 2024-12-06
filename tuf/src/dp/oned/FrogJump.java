package dp.oned;

import java.util.Arrays;

public class FrogJump {
    public int frogJump(int[] heights) {
        int len = heights.length;
        int[] dp = new int[len];
        Arrays.fill(heights, -1);

        return jumpHelper(len - 1, heights, dp);
    }
    private int jumpHelper(int idx, int[] heights, int[] dp){
        if (idx == 0){
            return 0;
        }
        if (dp[idx] != -1){
            return dp[idx];
        }
        int oneStep = jumpHelper(idx - 1, heights, dp) + Math.abs(heights[idx] - heights[idx - 1]);
        int twoSteps =  Integer.MAX_VALUE;
        if (idx > 1) {
            twoSteps = jumpHelper(idx - 2, heights, dp) + Math.abs(heights[idx] - heights[idx - 2]);
        }
        dp[idx] = Math.min(oneStep, twoSteps);
        return dp[idx];
    }
    public static void main(String[] args) {

    }
}

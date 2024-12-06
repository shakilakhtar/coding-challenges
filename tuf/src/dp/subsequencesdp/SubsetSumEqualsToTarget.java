package dp.subsequencesdp;

import java.util.Arrays;

public class SubsetSumEqualsToTarget {
    public boolean isSubsetSum(int[] arr, int target) {
        int len  = arr.length;
        int[][] dp = new int[len][target + 1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return recFunc(len - 1, target,len, arr, dp);
    }

    private boolean recFunc(int idx, int target, int len, int[] arr,int[][] dp){
        //memoization bottom up approach
     if (target == 0){
         return true;
     }
     if (idx == 0){
         return arr[0] == target;
     }
     if (dp[idx][target] != -1){
         return dp[idx][target] == 0 ? false : true;
     }

     boolean notTaken =  recFunc(idx - 1, target, len, arr, dp);
     boolean taken = false;
     //if taking element is not exceeding target
             if (arr[idx] <= target) {
                 taken = recFunc(idx - 1, target - arr[idx], len, arr, dp);
             }

        //if any  is true
     dp[idx][target] = notTaken || taken ? 1 : 0;

     return notTaken || taken;
    }


    public static void main(String[] args) {

    }
}

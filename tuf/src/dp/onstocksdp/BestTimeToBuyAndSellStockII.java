package dp.onstocksdp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {
    public int stockBuySell(int[] arr, int n) {
        //if blank
        if (n == 0){
            return 0;
        }
     int [][] dp = new int[n][2];
     for (int[] row:  dp){
         Arrays.fill(row, -1);
     }
     return recFunc(0,n,0,arr, dp);
    }

    private int recFunc(int i, int len, int buy, int[] arr, int[][] dp){
        if (i == len){
            return 0;
        }
        int profit = 0;
        if (dp[i][buy] != -1){
            return dp[i][buy];
        }
        if (buy == 0){
            profit = Math.max((-1)*arr[i] + recFunc(i + 1,len,1,arr,dp),
                    0 + recFunc(i + 1, len, 0,arr, dp) );
        }
        if(buy == 1) {
            //sell
            profit = Math.max(arr[i] + recFunc(i + 1, len, 0, arr, dp),
                    0 + recFunc(i + 1, len, 1, arr, dp));
        }
        dp[i][buy] = profit;
        return dp[i][buy];
    }
    public static void main(String[] args) {

    }
}

package com.challenge.neetcode.slidingwindow;

public class BestTimeToBuyAndSell {

    public int maxProfit(int[] prices) {
        int left = 0; // buy pointer
        int right = 1; //sell pointer
        int maxProfit = 0;
        while (right < prices.length){
            //check if this is a profit
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
                right+=1;
            }
            else {
                left=right;
                right+=1;
            }
        }
        return maxProfit;

    }

    public static void main(String[] args) {

    }
}

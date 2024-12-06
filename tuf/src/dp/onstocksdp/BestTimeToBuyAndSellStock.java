package dp.onstocksdp;

public class BestTimeToBuyAndSellStock {
    public int stockBuySell(int[] arr, int n) {
        int maxProfit = 0;
        int mini = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            int currentProfit = arr[i] - mini;
            if ( mini > arr[i]){
                mini = arr[i];
            }
            maxProfit = Math.max(currentProfit, maxProfit);
        }
        return maxProfit;
    }
    public static void main(String[] args) {

    }
}

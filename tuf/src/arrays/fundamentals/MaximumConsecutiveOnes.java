package arrays.fundamentals;

public class MaximumConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {

        int previousCounts = 0;
        int currentCounts = 0;
        for (int i = 0; i < nums.length ; i++) {
             if (nums[i]== 1){
                 currentCounts++;
             }else {
                 if(previousCounts < currentCounts){
                     previousCounts = currentCounts;

                 }
                 currentCounts = 0;
             }
        }
        return Math.max(previousCounts, currentCounts);
    }
    public static void main(String[] args) {
        int [] a = {1, 0, 1, 1, 1, 0, 1, 1, 1};
        int max1s = findMaxConsecutiveOnes(a);
        System.out.println(max1s);
    }
}

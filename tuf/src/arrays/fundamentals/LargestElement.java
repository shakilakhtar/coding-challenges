package arrays.fundamentals;

public class LargestElement {
    public int largestElement(int[] nums) {
        int largest = nums[0];
        for (int i = 0; i <nums.length ; i++) {
             if (largest < nums[i]) {
                 largest = nums[i];
             }
        }
        return largest;
    }

    public static void main(String[] args) {
        int [] a = {7, 4, 1, 5, 3};
    }
}

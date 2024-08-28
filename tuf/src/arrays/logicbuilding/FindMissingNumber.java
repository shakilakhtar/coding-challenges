package arrays.logicbuilding;

public class FindMissingNumber {
    public static int missingNumber(int[] nums) {

        int sumOfNumbers  = (nums.length * (nums.length + 1))/2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        return  sumOfNumbers - sum;
    }
    public static void main(String[] args) {
        int [] a = {0, 2, 3, 1, 4};
        int num = missingNumber(a);
        System.out.print(num);
    }
}

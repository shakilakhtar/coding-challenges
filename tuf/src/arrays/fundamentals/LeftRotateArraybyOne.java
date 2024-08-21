package arrays.fundamentals;

public class LeftRotateArraybyOne {
    public static void rotateArrayByOne(int[] nums) {
        int temp = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] =temp;
    }
    public static void main(String[] args) {
        int [] a = {1, 8, 7, 6, 5};
        rotateArrayByOne(a);
        for (int i: a) {
            System.out.print(i + " ");
        }
    }
}

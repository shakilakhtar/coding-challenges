package sorting;

public class BubbleSort {
    public static int[] bubbleSort(int[] nums) {

        for (int i = nums.length -1; i >=1; i--) {
            for (int j = 0; j <= i -1; j++) {

                if (nums[j] > nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int [] a = {7, 4, 1, 5, 3};
        bubbleSort(a);
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] +" ");
        }
    }
}

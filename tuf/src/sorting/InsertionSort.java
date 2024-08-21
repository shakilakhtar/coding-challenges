package sorting;

public class InsertionSort {
    public static int[] insertionSort(int[] nums) {

        for (int i = 0; i <= nums.length -1 ; i++) {

            int j =i;

            while (j>0 && nums[j - 1] > nums[j]){
                //swap
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int [] a = {7, 4, 1, 5, 3};
        insertionSort(a);
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] +" ");
        }
    }
}

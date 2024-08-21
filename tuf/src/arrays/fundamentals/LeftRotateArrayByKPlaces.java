package arrays.fundamentals;

public class LeftRotateArrayByKPlaces {
    public static void rotateArray(int[] nums, int k) {

        int [] temp = new int[k];
        for (int i = 0; i < k ; i++) {
            temp[i] = nums[i];
        }

        //shift the elements
        for (int i = k; i < nums.length; i++) {
            nums[i - k]=  nums[i];
        }
        // put back from temp
        for (int j = nums.length - k; j < nums.length; j++) {
            nums[j] = temp[j -(nums.length - k)];
        }

    }

    public static void reverseArray(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate the array to the left by k positions
    public static void rotateArrayOptimal(int[] nums, int k) {
        int n = nums.length;
        if (k > n){
            k = k % n;
        }
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int [] a = {1, 2, 3, 4, 5, 6};
        rotateArrayOptimal(a, 2);
        for (int i: a) {
            System.out.print(i + " ");
        }
    }
}

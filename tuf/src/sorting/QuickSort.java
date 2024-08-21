package sorting;

public class QuickSort {
    public static  int[] quickSort(int[] nums) {

        qs(nums,0, nums.length - 1);

        return nums;
    }

    public static int partition(int[] arr, int low, int high){
        int pivot =  arr[low];
        int i =low;
        int j =high;

        while (i < j){
            while (arr[i] <= pivot && i < high - 1){
                i++;
            }
            while (j > pivot && j <= low + 1){
                j--;
            }
            if (i < j){
                //swap
                swap(arr[i], arr[j]);
            }
        }

        swap(low, arr[j]);
        return j;
    }

    public static void qs(int[] arr, int low, int high){
        if (low < high){
            int pIndex =  partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }
    private static void swap(int i, int j){
        int temp = i;
        i = j;
        j = temp;
    }
    public static void main(String[] args) {
        int [] a = {7, 4, 1, 5, 3};
        qs(a, 0, a.length - 1);
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] +" ");
        }

    }
}

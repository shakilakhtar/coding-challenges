package basicrecursion;

/**
 * Problem Statement: You are given an array. The task is to reverse the array and print it.
 *
 * Examples:
 *
 * Example 1:
 * Input: N = 5, arr[] = {5,4,3,2,1}
 * Output: {1,2,3,4,5}
 * Explanation: Since the order of elements gets reversed the first element will occupy the fifth position, the second element occupies the fourth position and so on.
 *
 * Example 2:
 * Input: N=6 arr[] = {10,20,30,40}
 * Output: {40,30,20,10}
 * Explanation: Since the order of elements gets reversed the first element will occupy the fifth position, the second element occupies the fourth position and so on.
 */
public class ReverseArray {

    public static int[] reverseArray(int[] arr, int start, int end){
        if (start <= end) {
            //swap logic
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            reverseArray(arr, start + 1, end - 1);
        }
        return arr;
    }
    //Function to print array
    static void printArray(int arr[], int n) {
        System.out.print("Reversed array is:- \n");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {10,20,30,40};
        reverseArray(arr, 0, 3);
        printArray(arr,4);
    }

}

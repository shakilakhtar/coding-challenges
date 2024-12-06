package binarysearch.faqs;

public class FindPeakElement {
    public int findPeakElement(int[] arr) {

        int n = arr.length;
        int low = 1;
        int high =  n-2;
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n -1] > arr[n -2]) return n - 1;

        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return mid;
            }
            //peak is on the increasing graph
            else if (arr[mid] > arr[mid - 1]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}

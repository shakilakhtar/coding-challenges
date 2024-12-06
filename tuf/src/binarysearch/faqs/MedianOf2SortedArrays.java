package binarysearch.faqs;

public class MedianOf2SortedArrays {
    public double median(int[] arr1, int[] arr2) {

        int n1= arr1.length;
        int n2 =  arr2.length;

        //considering array1 is smaller than2
        // if greater take median of arr2, arr1
        if(n1 > n2) return median(arr2, arr1);
        int n = n1 + n2;
        //length of left half
        int left =  (n1 + n2 +1)/2;
        int low = 0;
        int high = n1;

        while (low <= high){
            int mid1 = (low + high)/2;
            int mid2 = left - mid1;
            // calculate l1, l2 r1 and r2
            int l1= mid1 > 0 ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? arr2[mid2 - 1] :Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? arr2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1){
                //if condition for finding median
                if (n % 2 == 1) return Math.max(l1,l2);
                else {
                    return (Math.max(l1,l2)+ Math.min(r1,r2)) / 2.0;
                }
            } else if (l1 > r2) {
                //eliminate right half of the array
                high = mid1 - 1;
            }
            else {
                //eliminate the left half of the array
                low = mid1 + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}

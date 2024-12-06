package binarysearch.faqs;

public class KthElementOf2SortedArrays {
    public int kthElement(int[] a, int[] b, int k) {
        int m= a.length;
        int n =  b.length;

        //considering array1 is smaller than2
        // if greater take median of arr2, arr1
        if(m > n) return kthElement(b, a,k);
        //length of left half
        int left =  k;
        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high){
            int mid1 = (low + high)/2;
            int mid2 = left - mid1;
            // calculate l1, l2 r1 and r2
            int l1= mid1 > 0 ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? b[mid2 - 1] :Integer.MIN_VALUE;
            int r1 = mid1 < m ? a[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1){
                //if condition for finding median
             return Math.max(l1,l2);
            } else if (l1 > r2) {
                //eliminate right half of the array
                high = mid1 - 1;
            }
            else {
                //eliminate the left half of the array
                low = mid1 + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}

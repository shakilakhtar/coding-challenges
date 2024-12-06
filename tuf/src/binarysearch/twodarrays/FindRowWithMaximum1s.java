package binarysearch.twodarrays;

public class FindRowWithMaximum1s {
    public int rowWithMax1s(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int countMax = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int count1s = m - lowerBound(mat[i],m,1);
            if (count1s > countMax){
                countMax = count1s;
                index = i;
            }
        }
        return index;
    }
    public int lowerBound(int[] nums, int n, int x) {
        int low = 0;
        int high =  n - 1;

        int lowerBoundIdx = n;

        while (low <= high){
            int mid = (low + high)/2;

            if (nums[mid] >= x){
                lowerBoundIdx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return lowerBoundIdx;
    }
    public static void main(String[] args) {
        
    }
}

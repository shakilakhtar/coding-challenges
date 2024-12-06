package binarysearch.onanswers;

public class FindSquareRootOfANumber {
    public long floorSqrt(long n) {
        long low = 1;
        long high = n;

        while (low <= high){
            long mid = (low + high)/2;
            if (mid * mid <= n){
                low = mid + 1;
            }else {
                    high = mid - 1;
            }
        }
        return high;
    }
    public static void main(String[] args) {

    }
}

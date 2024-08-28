package arrays.faqs.hard;

public class RepeatingAndMissingNumber {
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        //sum of all numbers
        long sumNums = (n * (n+1))/2;
        long sumNumsSquares = (n * (n + 1)*(2*n + 1))/6;
        long s1 = 0L;
        long s2 = 0L;
        for (int i = 0; i <n ; i++) {
             s1 += nums[i];
             s2 += (long)nums[i] * (long)nums[i];
        }

        //apply maths
        // x - y = s1 - sumNums
        // x2 - y2 = s2 - sumNumsSquares that is (x + y) (x - y) = b
        // x +  y = (s2 - sumNumsSquares) / (s1 - sumNums) is x + y

        long a = s1 - sumNums; // x - y
        long b = s2 - sumNumsSquares; // (x + y) (x - y)
        b = b / a;
        long x = (a + b) / 2;
        long y = x - a;

        return  new int[] {(int)x, (int)y};
    }
    public static void main(String[] args) {
        int [] a = {1, 2, 3, 6, 7, 5, 7};
        int [] res = findMissingRepeatingNumbers(a);
        for (int i = 0; i < res.length ; i++) {
            System.out.print(res[i] +" ");
        }
    }
}

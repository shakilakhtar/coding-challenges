package basicmath;

/**
 * Given an integer N, return true it is an Armstrong number otherwise return false.
 *
 * An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
 *
 * Examples
 * Example 1:
 * Input:N = 153
 * Output:True
 * Explanation: 13+53+33 = 1 + 125 + 27 = 153
 * Example 2:
 * Input:N = 371
 * Output: True
 * Explanation: 33+53+13 = 27 + 343 + 1 = 371
 */
public class ArmstrongNumbers {
    public static boolean isArmstrongNumber(int x){

        int num = Math.abs(x);
        int lastDigit = 0;
        int sum = 0;

        while (num >0){
            lastDigit = num % 10;
            sum = sum + (lastDigit * lastDigit * lastDigit);
            num = num / 10;
        }
        if (sum == x || -sum == x){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        boolean a = isArmstrongNumber(153);
        System.out.println(a);
    }
}

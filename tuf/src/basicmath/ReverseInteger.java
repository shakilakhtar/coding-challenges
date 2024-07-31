package basicmath;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class ReverseInteger {
    static public int reverse(int x) {
        int num = Math.abs(x);
        int lastDigit = 0;
        int rev =  0;
        while ( num >0 ) {
            lastDigit = num % 10;
            rev =  (rev*10) + lastDigit;
            num = num / 10;
        }
        if (x < 0){
            return rev*-1;
        }
        return rev;
    }
    public static void main(String[] args) {

        int rev = reverse(-123);
        System.out.println(rev);
    }
}

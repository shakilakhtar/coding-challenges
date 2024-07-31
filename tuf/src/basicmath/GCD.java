package basicmath;

/**
 * Given two integers N1 and N2, find their greatest common divisor.
 *
 * The Greatest Common Divisor of any two integers is the largest number that divides both integers.
 *
 * Examples
 * Example 1:
 * Input:N1 = 9, N2 = 12
 *
 * Output:3
 * Explanation:Factors of 9: 1, 3 and 9
 * Factors of 12: 1, 2, 3, 4, 6, 12
 * Common Factors: 1, 3 out of which 3 is the greatest hence it is the GCD.
 * Example 2:
 * Input:N1 = 20, N2 = 15
 *
 * Output: 5
 * Explanation:Factors of 20: 1, 2, 4, 5
 * Factors of 15: 1, 3, 5
 * Common Factors: 1, 5 out of which 5 is the greatest hence it is the GCD.
 */
public class GCD {
    public static int findGcd(int a, int b) {
        while (a > 0 && b >0){
            if (a > b){
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        if (a == 0){
            return b;
        }else {
            return a;
        }

    }
        public static void main(String[] args) {

        int gcd = findGcd(20, 15);
        System.out.println(gcd);
    }
}

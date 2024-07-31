package basicmath;

/**
 * Check if a number is prime or not
 *
 *
 * 56
 *
 * 1
 * Problem Statement: Given an integer N, check whether it is prime or not. A prime number is a number that is only divisible by 1 and itself and the total number of divisors is 2.
 *
 * Examples
 * Example 1:
 * Input:N = 2
 * Output:True
 * Explanation: 2 is a prime number because it has two divisors: 1 and 2 (the number itself).
 * Example 2:
 * Input:N =10
 * Output: False
 * Explanation: 10 is not prime, it is a composite number because it has 4 divisors: 1, 2, 5 and 10.
 */
public class PrimeNumber {
    static boolean checkPrime(int n){
        int count  = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count = count + 1;
            // If n is not a perfect square,
            // count its reciprocal factor.
            if (n / i != i) {
                count = count + 1;
            }
        }
        }
        if(count == 2){
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {

        boolean p = checkPrime(13);
        System.out.println(p);
    }
}

package basicrecursion;

/**
 * Given a number X,  print its factorial.
 *
 * To obtain the factorial of a number, it has to be multiplied by all the whole numbers preceding it. More precisely X! = X*(X-1)*(X-2) … 1.
 *
 * Note: X  is always a positive number.
 *
 * Examples:
 *
 * Example 1:
 * Input: X = 5
 * Output: 120
 * Explanation: 5! = 5*4*3*2*1
 *
 * Example 2:
 * Input: X = 3
 * Output: 6
 * Explanation: 3!=3*2*1
 */
public class FactorialOfANumber {

    static int factorial(int X) {
        if (X == 0){
            return 1;
        }
        return X * factorial(X-1);
    }
    public static void main(String[] args) {

        int res = factorial(1);
        System.out.println(res);
    }
}

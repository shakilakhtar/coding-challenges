package patterns;

/**
 * Problem statement
 * Ninja has been given a task to print the required pattern and he asked for your help with the same.
 *
 * You must print a matrix corresponding to the given number pattern.
 *
 * Example:
 * Input: ‘N’ = 4
 *
 * Output:
 *
 * 4444444
 * 4333334
 * 4322234
 * 4321234
 * 4322234
 * 4333334
 * 4444444
 * Detailed explanation ( Input/output format, Notes, Images )
 * Constraints :
 * 1  <= N <= 10^2
 * Time Limit: 1 sec
 * Sample Input 1:
 * 3
 * Sample Output 1:
 * 33333
 * 32223
 * 32123
 * 32223
 * 33333
 * Sample Input 2 :
 * 5
 * Sample Output 2 :
 * 555555555
 * 544444445
 * 543333345
 * 543222325
 * 543212345
 * 543222325
 * 543333345
 * 544444445
 * 555555555
 * Sample Input 3 :
 * 4
 * Sample Output 3 :
 * 4444444
 * 4333334
 * 4322234
 * 4321234
 * 4322234
 * 4333334
 * 4444444
 */
public class Pattern22TheNumberPattern {
    public static void getNumberPattern(int n) {
        // Write your code here.
        for (int i = 0; i <2*n -1 ; i++) {

            for (int j = 0; j <2*n -1 ; j++) {
                int topDistance = i;
                int leftDistance = j;
                int rightDistance = (2*n -1) -1 - j;
                int bottomDistance = (2*n -1) -1 - i;
                System.out.print(n - Math.min(Math.min(topDistance, leftDistance)
                        ,Math.min(rightDistance, bottomDistance)));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        getNumberPattern(3);
    }
}

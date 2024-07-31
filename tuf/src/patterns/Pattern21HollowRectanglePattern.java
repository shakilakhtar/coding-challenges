package patterns;

/**
 * Problem statement
 * Ninja has been given a task to print the required star pattern and he asked your help for the same.
 *
 * You must return an ‘N’*’N’ matrix corresponding to the given star pattern.
 *
 * Example:
 * Input: ‘N’ = 4
 *
 * Output:
 *
 * ****
 * *  *
 * *  *
 * ****
 * Detailed explanation ( Input/output format, Notes, Images )
 * Constraints :
 * 1  <= N <= 10^2
 * Time Limit: 1 sec
 * Sample Input 1:
 * 3
 * Sample Output 1:
 * ***
 * * *
 * ***
 * Sample Input 2 :
 * 5
 * Sample Output 2 :
 * *****
 * *   *
 * *   *
 * *   *
 * *****
 * Sample Input 3 :
 * 8
 * Sample Output 3 :
 * ********
 * *      *
 * *      *
 * *      *
 * *      *
 * *      *
 * *      *
 * ********
 */
public class Pattern21HollowRectanglePattern {
    public static void getStarPattern(int n) {
        // Write your code here
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1){
                    System.out.print('*');
                }
                else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {

        getStarPattern(4);
    }
}

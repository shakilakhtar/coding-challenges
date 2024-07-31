package patterns;

/**
 * Problem statement
 * Sam is curious about symmetric patterns, so he decided to create one.
 *
 * For every value of ‘N’, return the symmetry as shown in the example.
 *
 * Example:
 * Input: ‘N’ = 3
 *
 * Output:
 * * * * * * *
 * * *     * *
 * *         *
 * *         *
 * * *     * *
 * * * * * * *
 * Detailed explanation ( Input/output format, Notes, Images )
 * Constraints :
 * 1  <= N <= 25
 * Time Limit: 1 sec
 * Sample Input 1:
 * 3
 * Sample Output 1:
 * * * * * * *
 * * *     * *
 * *         *
 * *         *
 * * *     * *
 * * * * * * *
 * Sample Input 2 :
 * 1
 * Sample Output 2 :
 * * *
 * * *
 */
public class Pattern19 {
    public static void symmetry(int n) {
        // Write your code here
        int space = 0;
        for (int i = 0; i <n ; i++) {
         
        // print star
            for (int j = 1; j <= n - i; j++) {
                System.out.print('*');
            }
        
        //print space 
            for (int s = 0; s < space ; s++) {
                System.out.print(" ");
            }
        
        //print star
            for (int k = 1; k <= n - i; k++) {
                System.out.print('*');
            }
            space = space + 2;
            System.out.println();
        }
        space = 2*n -2;
        for (int i = 1; i <=n ; i++) {

            // print star
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }

            //print space
            for (int s = 0; s < space ; s++) {
                System.out.print(" ");
            }

            //print star
            for (int k = 1; k <= i; k++) {
                System.out.print('*');
            }
            space = space - 2;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        symmetry(3);
    }
}

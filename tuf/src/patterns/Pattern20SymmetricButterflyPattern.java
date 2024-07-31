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
 * *         *
 * * *     * *
 * * * * * * *
 * * *     * *
 * *         *
 * Detailed explanation ( Input/output format, Notes, Images )
 * Constraints :
 * 1  <= N <= 25
 * Time Limit: 1 sec
 * Sample Input 1:
 * 3
 * Sample Output 1:
 * *         *
 * * *     * *
 * * * * * * *
 * * *     * *
 * *         *
 * Sample Input 2 :
 * 1
 * Sample Output 2 :
 * *
 */
public class Pattern20SymmetricButterflyPattern {
    public static void symmetry(int n) {
        // Write your code here
        int spaces  = 2*n - 2;
        for (int i = 1; i <=2*n -1 ; i++) {
            int stars =  i;

            if (i > n){
             stars = 2*n - i;
            }
            //print star
            for (int j = 1; j <=stars ; j++) {
                System.out.print('*');
            }
            //print space
            for (int s = 1; s <=spaces ; s++) {
                System.out.print(" ");
            }
            //print star
            for (int k = 1; k <=stars ; k++) {
                System.out.print('*');
            }
            System.out.println();
            if (i < n ){
                spaces = spaces - 2;
            }else {
                spaces = spaces + 2;
            }
        }

    }
    public static void main(String[] args) {
        symmetry(5);
    }
}

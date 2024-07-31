package patterns;

public class Pattern12 {
    static void numberCrown(int n) {
        // Write your code here.
        int space = 2*(n -1);
        for (int i = 1; i <=n ; i++) {

            //print number
            for (int j = 1; j <=i ; j++) {
                System.out.print(j);
            }
            //print space
            for (int l = 1; l <=space ; l++) {
                System.out.print(" ");
            }
            //print number
            for (int k = i; k >=1 ; k--) {
                System.out.print(k);
            }
            System.out.println();
            space = space -2 ;
        }
    }
    public static void main(String[] args) {

        numberCrown(4);
    }
}

package patterns;

public class Pattern14 {
    static void nLetterTriangle(int n) {
        // Write your code here.
        for (int i = 0; i <n ; i++) {
            for (char j = 'A'; j <='A' + i; j++) {

                System.out.print(j);
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {

        nLetterTriangle(5);
    }
}

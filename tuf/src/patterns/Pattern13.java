package patterns;

public class Pattern13 {
    static void nNumberTriangle(int n) {
        // Write your code here.
        int start = 1;
        for (int i = 1; i <=n ; i++) {

            for (int j = 1; j <=i ; j++) {
                System.out.print(start + " ");
                start++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        nNumberTriangle(5);
    }
}

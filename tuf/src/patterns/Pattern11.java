package patterns;

public class Pattern11 {
    static void nBinaryTriangle(int n) {
        // Write your code here.
        for (int i =1; i<=n; i++){
            int start = 1;
            if ( i % 2 == 0){
                start = start -1;
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print(start);
                if (start == 0){
                    start = 1;
                }else {
                    start = 0;
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        nBinaryTriangle(5);
    }
}

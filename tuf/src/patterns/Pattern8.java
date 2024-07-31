package patterns;

public class Pattern8 {
    static void printTriangle(int n) {
        // code here
        for(int i =0 ; i < n; i++){

            //print space

            for(int j=0; j <= i - 1; j++){
                System.out.print(" ");
            }


            //print star

            for(int k=0; k < 2*n - 2*i - 1; k++){
                System.out.print("*");
            }
            //print space
            for(int l=0; l <= i - 1; l++){
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
        printTriangle(5);

    }
}

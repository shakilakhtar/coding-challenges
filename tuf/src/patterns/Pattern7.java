package patterns;

public class Pattern7 {
    static void printTriangle(int n) {
        // code here n - i  2i -1  n - i
        for(int i = 0; i < n; i++){

            //print space
            for(int j =0; j < n-i-1; j++){
                System.out.print(" ");
            }

            //print star
            for(int k = 0; k < 2*i + 1; k++){
                System.out.print("*");
            }

            //print space
            for(int l =0; l < n -i -1; l++){
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
        printTriangle(5);
    }
}

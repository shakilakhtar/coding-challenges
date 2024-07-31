package patterns;

public class PrintTriangle6 {
    static void printTriangle(int n) {
        // code here
        for(int i = 1; i <=n; i++){

            int j = 1;
            while(j  <= n -i + 1){
                System.out.print(j+ " ");
                j++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printTriangle(5);
    }
}

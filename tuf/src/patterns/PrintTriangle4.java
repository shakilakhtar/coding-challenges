package patterns;

public class PrintTriangle4 {
    static void printTriangle(int n) {
        // code here
        for(int i = 1; i <= n; i++){
            int j = i;
            while(j > 0){
                System.out.print(i +" ");
                j--;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        printTriangle(5);
    }
}

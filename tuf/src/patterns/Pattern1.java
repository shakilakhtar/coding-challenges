package patterns;

public class Pattern1 {
   static void printSquare(int n) {
        // code here
       for(int i=0;i <n; i++){
           for(int j =0; j < n; j++){
               System.out.print("* ");
           }
           System.out.println();
       }
    }
    public static void main(String[] args) {

       printSquare(3);
    }
}

package patterns;

public class Pattern10 {
    static void pattern10(int n){
        for(int i =1; i <= 2*n -1; i++){
            if(i > n){
                for (int j =1; j <= 2*n - i; j++){
                    System.out.print("*");
                }
            }
            else {
                for (int j =1; j <= i; j++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        pattern10(5);
    }
}

package recursion.implementation;

public class Powxn {
    public double myPow(double x, int n) {
        if (n < 0){
            return 1.0/myPow(x, -n);
        }
        if (n == 0) {
            return 1.0;
        }
        if (n % 2 == 1){ // odd power

            return x * myPow(x, n - 1);
        }else {
            return myPow(x * x , n/2);
        }
    }
    public static void main(String[] args) {

    }
}

package basicrecursion;

public class SumOfFirstNNumbers {
    static int sum = 0;
    public static int NnumbersSum(int N) {
        //your code goes here
        if(N <=0){
            return 0;
        }

        return N + NnumbersSum(N-1);
    }
    public static void main(String[] args) {
        int res = NnumbersSum(5);
        System.out.println(res);
    }

}

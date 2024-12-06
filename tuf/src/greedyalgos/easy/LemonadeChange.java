package greedyalgos.easy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for (int i = 0; i < bills.length ; i++) {
            if (bills[i] == 5){
                fives = fives + 1;
            } else if (bills[i] == 10) {
                if (fives > 0) {
                    tens = tens + 1;
                    fives = fives - 1;
                }else {
                    return false;
                }

            }
            else {
                if (fives > 0 && tens > 0){
                    fives = fives - 1;
                    tens = tens - 1;
                } else if (fives >= 3) {
                    fives = fives - 3;
                }else {
                    return false;
                }
            }
        }

        return true;
}
    public static void main(String[] args) {

    }
}

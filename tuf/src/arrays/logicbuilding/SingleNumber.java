package arrays.logicbuilding;

public class SingleNumber {
    public static int singleNumber(int[] nums) {

        int xorr = 0;
        for (int i = 0; i <nums.length ; i++) {
            xorr ^= nums[i];

        }

        return xorr;
    }
    public static void main(String[] args) {
        int [] a = {2, 2, 4, 4, 1};
        int singleNum = singleNumber(a);
        System.out.print(singleNum);
    }
}

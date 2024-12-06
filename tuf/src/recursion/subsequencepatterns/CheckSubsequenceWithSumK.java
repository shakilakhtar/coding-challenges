package recursion.subsequencepatterns;

public class CheckSubsequenceWithSumK {
    public boolean checkSubsequenceSum(int[] nums, int k) {

        return solve(0, nums.length,nums,k);
    }

    private boolean solve(int index, int len, int [] nums, int sum){

        //there are always two possible path
        //either include element or exclude

        //base case

        if (sum == 0){
            return true;
        }
        //case two when sum in negative
        if (sum < 0 ){
            return false;
        }
        //all element processed check is sum is 0
        if (index == len){
            return sum == 0;
        }

        //include the element at index
        boolean path1 = solve(index + 1, len, nums , sum - nums[index]);

        //do not take (exclude) element at the index
        boolean path2 = solve(index + 1, len, nums, sum);

        return (path1 || path2);
    }

    public static void main(String[] args) {

    }
}

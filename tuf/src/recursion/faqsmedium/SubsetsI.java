package recursion.faqsmedium;

import java.util.ArrayList;
import java.util.List;

public class SubsetsI {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> results  = new ArrayList<>();
        recFunc(0,0,nums,results);
        return results;
    }

    private void recFunc(int idx, int sum, int[] nums, List<Integer> results){
        if (idx == nums.length){
            results.add(sum);
            return;
        }
        //recursive include current element
        recFunc(idx + 1, sum + nums[idx],nums,results);
        //recursively exclude current element
        recFunc(idx + 1, sum, nums, results);
    }

    public static void main(String[] args) {

    }
}

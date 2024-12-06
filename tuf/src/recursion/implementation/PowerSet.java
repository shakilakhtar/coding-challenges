package recursion.implementation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> powerSet(int[] nums) {
        //Final result list
        List<List<Integer>> ans =  new ArrayList<>();
        //Current list
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums.length, nums, current, ans);
        return ans;
    }

    private void backtrack(int index, int len, int[] nums, List<Integer> current,
                           List<List<Integer>> results){

        //base case
        if (index == len){
            // add current to results list and return
            results.add(new ArrayList<>(current));
            return;
        }
        //There are two possible case either include element or exclude
        // Recursive case: Exclude the current element and move to the next element
        backtrack(index + 1, len, nums, current, results);

        //case 2 include
        //  the current element in the subset and move to the next element

        current.add(nums[index]);
        backtrack(index + 1,len, nums, current, results);

        // Backtrack: remove the last added element to explore other subsets
        current.remove(current.size() - 1);

    }
    public static void main(String[] args) {

    }
}

package recursion.faqsmedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results  = new ArrayList<>();
        List<Integer> v =  new ArrayList<>();
        Arrays.sort(candidates);
        recFunc(candidates,0,target,v,results);
        return results;
    }

    private void recFunc(int [] cl, int idx, int sum , List<Integer> v, List<List<Integer>> results){

        if (sum == 0){
            results.add(new ArrayList<>(v));
            return;
        }
        if (sum < 0 || idx >= cl.length){
            return;
        }
        //loop through the array to skip duplicates

        for (int i = idx; i < cl.length; i++) {
        // Skip duplicates to avoid redundant combinations
            if (i > idx && cl[i] == cl[i - 1]){
                continue;
            }
            //add current element to the combination
            v.add(cl[i]);
            //recursion to the next element
            recFunc(cl, i + 1, sum - cl[i],v,results);
            //remove the last element added to backtrack
            v.remove(v.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}

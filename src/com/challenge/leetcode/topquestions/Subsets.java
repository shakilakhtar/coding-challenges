package com.challenge.leetcode.topquestions;

import java.util.*;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * @author shakilakhtar
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        toFindAllSubsets(nums, results, subset, 0);
        return results;
    }

    private void toFindAllSubsets(int[] nums, List<List<Integer>> results, List<Integer> subset, int startIndex) {

        results.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {

            subset.add(nums[i]);
            toFindAllSubsets(nums, results, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }



    //Recursive way of finding all subsets
    public List<List<Integer>> subsetsRecursive(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

//Backtracking solution of finding subsets
    List<List<Integer>> output = new ArrayList();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new ArrayList(curr));

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsetsBacktracking(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
}

package arrays.faqs.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInAnArray {
    public int[] leaders(int[] nums) {
        List<Integer> leaders =  new ArrayList<>();
        int max = nums[nums.length - 1];
        leaders.add(max);
        for (int i = nums.length -1 -1; i >= 0; i--) {
             if (nums[i] > max){
                 max = nums[i];
                 leaders.add(max);
             }
        }
        int [] res = new int[leaders.size()];
        for (int i = leaders.size() - 1; i >=0 ; i--) {
           res[leaders.size() - 1 - i] = leaders.get(i);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}

package recursion.faqsmedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results  = new ArrayList<>();
        // Convert the array to a list for easier manipulation
        List<Integer> candidatesList = Arrays.stream(candidates).boxed().collect(Collectors.toList());
         recFunc(candidatesList, candidatesList.size() - 1, target,new ArrayList<>(),results);

         return results;
    }

    private void recFunc(List<Integer> cl,int idx, int sum,List<Integer> current,
                         List<List<Integer>> results){

        if (sum == 0){
            results.add(new ArrayList<>(current));
            return;
        }

        if (sum < 0 || idx < 0){
            return;
        }

        //exclude the current element
        recFunc(cl,idx - 1,sum,current,results);

        //include the current element in the subsequence
        // before including add this to list
        current.add(cl.get(idx));
        recFunc(cl,idx,sum - cl.get(idx),current,results);
        //remove element when not considering before it
        current.remove(current.size() - 1);

    }
    public static void main(String[] args) {

    }
}

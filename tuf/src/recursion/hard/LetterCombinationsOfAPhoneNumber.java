package recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    String [] map  = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> results =  new ArrayList<>();
        if (digits.length() == 0) {
            return results;
        }
        recHelper(0,"",digits,results);
        return results;
    }

    private void recHelper(int idx, String current, String digits, List<String> results){

        //base case if idx reached to end of digits
        if (idx == digits.length()){
            //add current to answers
            results.add(current);
            return;
        }
        //get character corresponding to digit
        String s =  map[digits.charAt(idx) - '0'];
        //loop through the corresponding character

        for (int i = 0; i < s.length(); i++) {

            //recursion
            recHelper(idx +1, current + s.charAt(i), digits, results);
        }
    }
    public static void main(String[] args) {

    }
}

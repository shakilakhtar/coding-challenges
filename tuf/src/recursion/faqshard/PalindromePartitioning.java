package recursion.faqshard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        List<String> path  = new ArrayList<>();

        recFunc(0,s,path,results);
        return results;
    }

    private void recFunc(int idx, String s, List<String> path, List<List<String>> results){

        if (idx == s.length()){
            results.add(new ArrayList<>(path));
            return;
        }
        // Iterate over the substring starting from 'index'
        for (int i = idx; i < s.length(); i++) {
            // Check if the substring s[index..i] is a palindrome
            if (isPalindrome(s, idx, i)){
            // If true, add it to the current path
                path.add(s.substring(idx, i + 1));
                //// Recursion for the remaining substring
                recFunc(i + 1,s,path,results);
                // Backtrack: remove the last added substring
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){

        while (start <= end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}

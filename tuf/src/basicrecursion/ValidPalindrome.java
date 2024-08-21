package basicrecursion;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
       return isPalindrome(0,s);
    }

    public static boolean isPalindrome(int idx, String s){
        if (idx >= s.length()/2){
            return true;
        }
        if (s.charAt(idx) != s.charAt(s.length() -idx -1)){
            return false;
        }
        return isPalindrome(idx+1, s);
    }
    public static void main(String[] args) {

        boolean res = isPalindrome("MADAM");
        System.out.println(res);
    }
}

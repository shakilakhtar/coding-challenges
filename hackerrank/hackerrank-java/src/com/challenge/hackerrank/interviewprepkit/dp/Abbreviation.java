package com.challenge.hackerrank.interviewprepkit.dp;

/**
 * You can perform the following operations on the string, :
 * <p>
 * Capitalize zero or more of 's lowercase letters.
 * Delete all of the remaining lowercase letters in .
 * Given two strings,  and , determine if it's possible to make  equal to  as described. If so, print YES on a new line. Otherwise, print NO.
 * <p>
 * For example, given  and , in  we can convert  and delete  to match . If  and , matching is not possible because letters may only be capitalized or discarded, not changed.
 * <p>
 * Function Description
 * <p>
 * Complete the function  in the editor below. It must return either  or .
 * <p>
 * abbreviation has the following parameter(s):
 * <p>
 * a: the string to modify
 * b: the string to match
 * Input Format
 * <p>
 * The first line contains a single integer , the number of queries.
 * <p>
 * Each of the next  pairs of lines is as follows:
 * - The first line of each query contains a single string, .
 * - The second line of each query contains a single string, .
 * <p>
 * Constraints
 * <p>
 * String  consists only of uppercase and lowercase English letters, ascii[A-Za-z].
 * String  consists only of uppercase English letters, ascii[A-Z].
 * Output Format
 * <p>
 * For each query, print YES on a new line if it's possible to make string  equal to string . Otherwise, print NO.
 * <p>
 * Sample Input
 * <p>
 * 1
 * daBcd
 * ABC
 * Sample Output
 * <p>
 * YES
 * Explanation
 * <p>
 * image
 * <p>
 * We have  daBcd and  ABC. We perform the following operation:
 * <p>
 * Capitalize the letters a and c in  so that  dABCd.
 * Delete all the remaining lowercase letters in  so that  ABC.
 * Because we were able to successfully convert  to , we print YES on a new line.
 */
public class Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
        dp[0][0] = true; // emptyString == emptyString

        boolean uppercase = false;
        for (int row = 1; row <= a.length(); row++) {
            int i = row - 1;

            // This code sets the first column to true until
            // the first instance of an upper-case letter
            if (isUpperCase(a.charAt(i)) || uppercase) {
                uppercase = true;
                dp[row][0] = false; // (upper-case letter) != emptyString
            } // (lower-case -> emptyString) == emptyString
            else dp[row][0] = true;
        }
        // fill in dp matrix
        for (int row = 1; row <= a.length(); row++) {
            int i = row - 1;

            for (int col = 1; col <= b.length(); col++) {
                int j = col - 1;

                if (a.charAt(i) == b.charAt(j)) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else if (isUpperCase(a.charAt(i))) {
                    dp[row][col] = false;
                } else if (toUpperCase(a.charAt(i)) == b.charAt(j)) {
                    dp[row][col] = dp[row - 1][col - 1] || dp[row - 1][col];
                } else {
                    dp[row][col] = dp[row - 1][col];
                }
            }
        }
        print(dp, a, b);
        return dp[a.length()][b.length()] ? "YES" : "NO";
    }

    private static char toUpperCase(char c) {
        int ascii = (int) c;
        if (ascii < 97 || ascii > 122) {
            try {
                throw new Exception("Char must be lower-case: " + c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (char) (ascii - 32);
    }

    private static boolean isUpperCase(char c) {
        String letter = String.valueOf(c);
        return letter.toUpperCase().equals(letter);
    }


    private static void print(boolean[][] dp, String a, String b) {

        System.out.print("    ");
        for (int i = 0; i < b.length(); i++) {
            System.out.printf("%2s", b.charAt(i));
        }
        System.out.println();
        System.out.print("  ");
        for (int row = 0; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                if (col == 0 && row > 0) {
                    System.out.printf("%2s", a.charAt(row - 1));
                }
                if (dp[row][col]) {
                    System.out.printf("%2d", 1);
                } else {
                    System.out.printf("%2d", 0);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static String abbreviation2(String a, String b) {
        boolean[][] isValid = new boolean[a.length() + 1][b.length() + 1];
        // initializing the first raw to all false; ie. if b is
        // not empty, isValid will always be false
        isValid[0][0] = true;
        // array initialization - if a is non-empty but b is empty,
        // then isValid == true iff remaining(a) != contain uppercase
        boolean containsUppercase = false;
        for (int k = 1; k <= a.length(); k++) {
            int i = k - 1;
            // if the pointer at string a is uppercase
            if (a.charAt(i) <= 90 && a.charAt(i) >= 65 || containsUppercase) {
                containsUppercase = true;
                isValid[k][0] = false;
            } else isValid[k][0] = true;
        }
        // tabulation from start of string
        for (int k = 1; k <= a.length(); k++) {
            for (int l = 1; l <= b.length(); l++) {
                int i = k - 1;
                int j = l - 1;
                // when the characters are equal, set = previous character bool.
                if (a.charAt(i) == b.charAt(j)) {
                    isValid[k][l] = isValid[k - 1][l - 1];
                    continue;
                }
                // elif uppercase a == b, set = prev character bool. or just eat a.
                else if ((int) a.charAt(i) - 32 == (int) b.charAt(j)) {
                    isValid[k][l] = isValid[k - 1][l - 1] || isValid[k - 1][l];
                    continue;
                }
                // elif a is uppercase and no more b, or uppercase a is not b, then false
                else if (a.charAt(i) <= 90 && a.charAt(i) >= 65) {
                    isValid[k][l] = false;
                    continue;
                }
                //else just eat a
                else {
                    isValid[k][l] = isValid[k - 1][l];
                    continue;
                }
            }
        }
        return isValid[a.length()][b.length()] ? "YES" : "NO";
    }

    public static void main(String[] args) {

        String a = "daBcd";
        String b = "ABC";
        abbreviation(a, b);

    }
}

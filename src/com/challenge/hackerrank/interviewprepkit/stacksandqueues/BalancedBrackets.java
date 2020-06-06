package com.challenge.hackerrank.interviewprepkit.stacksandqueues;

import java.util.*;

/**
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * <p>
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
 * <p>
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
 * <p>
 * By this logic, we say a sequence of brackets is balanced if the following conditions are met:
 * <p>
 * It contains no unmatched brackets.
 * The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 * Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.
 * <p>
 * Function Description
 * <p>
 * Complete the function isBalanced in the editor below. It must return a string: YES if the sequence is balanced or NO if it is not.
 * <p>
 * isBalanced has the following parameter(s):
 * <p>
 * s: a string of brackets
 * Input Format
 * <p>
 * The first line contains a single integer , the number of strings.
 * Each of the next  lines contains a single string , a sequence of brackets.
 * <p>
 * Constraints
 * <p>
 * , where  is the length of the sequence.
 * All chracters in the sequences ∈ { {, }, (, ), [, ] }.
 * Output Format
 * <p>
 * For each string, return YES or NO.
 * <p>
 * Sample Input
 * <p>
 * 3
 * {[()]}
 * {[(])}
 * {{[[(())]]}}
 * Sample Output
 * <p>
 * YES
 * NO
 * YES
 * Explanation
 * <p>
 * The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
 * The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
 * The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
 */
public class BalancedBrackets {
    public static String isBalanced(String s) {
        char[] c = s.toCharArray();
        Stack<String> stack = new Stack<>();
        String flag = "NO";
        for (int i = 0; i < c.length; i++) {
            String cs = String.valueOf(c[i]);
            if (cs.equals("(") || cs.equals("{") || cs.equals("[")) {
                //push
                stack.push(cs);
            } else if (cs.equals(")") || cs.equals("}")
                    || cs.equals("]")) {
                String pc = "";
                if (!stack.empty()) {
                    pc = stack.pop();
                }
                if (pc.equals("(") &cs.equals(")") ) {
                    flag = "YES";
                } else if (pc.equals("{") & cs.equals("}")){
                    flag = "YES";
                } else if (pc.equals("[") & cs.equals("]")) {
                    flag = "YES";
                } else {
                    flag = "NO";
                    break;
                }
            } else {

            }
        }
        if (stack.size() > 0) {
            flag = "NO";
        }

        return flag;
    }

    public static void main(String[] args) {
        String s = "{[(])}";
        System.out.println(isBalanced(s));
    }
}

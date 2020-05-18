package com.challenge.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 * @author Shakil Akhtar on 17/12/19
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        //'(', ')', '{', '}', '[',']';
        if(s.isEmpty()){
            return true;
        }
        char[] brackets = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<brackets.length;i++){
            if(brackets[i]=='(' || brackets[i]=='{' || brackets[i]=='['){
                //push into stack
                stack.push(brackets[i]);
            }
            if(brackets[i]==')' || brackets[i]=='}' || brackets[i]==']'){
                //pop from stack
                if(stack.empty()) {
                    stack.push('#');
                }
                    Character c = stack.pop();
                    if (brackets[i] == ')') {
                        if (c != '(') {
                            return false;
                        }
                    } else if (brackets[i] == '}') {
                        if (c != '{') {
                            return false;
                        }
                    } else if (brackets[i] == ']') {
                        if (c != '[') {
                            return false;
                        }
                    }
            }
        }
        if(!stack.empty()){
            return false;
        }
      return true;
    }
    public static void main(String[] args) {

        String s ="]";
        boolean v =isValid(s);
        System.out.println(v);
    }
}

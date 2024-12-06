package stacknqueue.monotonicstack;

import java.util.Stack;

public class NextGreaterElement {
    public int[] nextLargerElement(int[] arr) {
        int len  = arr.length;
        //an array to store next greater elements
        int[] nge = new int[len];
        //stack to build logic
        Stack<Integer> stack = new Stack<>();

        for (int i = len - 1; i>=0; i--){
            int current = arr[i];
            while (!stack.isEmpty()
                    && stack.peek() <= current){
                stack.pop();
            }
           // if the current element's greater is not found empty stack
            if (stack.isEmpty()){
                nge[i] = -1;
            }
            else {
                nge[i] = stack.peek();
            }
            stack.push(current);
        }
        return nge;
    }
    public static void main(String[] args) {

    }
}

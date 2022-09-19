package Longest_Valid_Parentheses_32;

import java.util.Stack;

public class Solution {
    //"((()()))()()()"
    public int longestValidParentheses(String s) {
        if (null == s) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int index = 0; index < s.length(); index++) {
            if ('(' == s.charAt(index)) {
                stack.push(index);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.add(index);
                } else {
                    if (index - stack.peek() > max) {
                        max = index - stack.peek();
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "((()()))()()()";
        int max = solution.longestValidParentheses(a);
        System.out.println();
    }
}

package test;

import java.util.LinkedList;
import java.util.Stack;

public class P20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isValid("]");
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.peek();
                    if (c == ')' && top == '(') {
                        stack.pop();
                    } else if (c == '}' && top == '{') {
                        stack.pop();
                    } else if (c == ']' && top == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}

package valid_parentheses_20;

import java.util.LinkedList;

public class Solution {
    public static boolean isValid(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    char top = stack.peek();
                    if ('(' == top && ')' == c) {
                        stack.pop();
                    } else if ('{' == top && '}' == c) {
                        stack.pop();
                    } else if ('[' == top && ']' == c) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isValid("(])");
        System.out.println(1);
    }
}

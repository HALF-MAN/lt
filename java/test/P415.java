package test;

import java.util.Stack;

public class P415 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = solution.addStrings("6", "501");
        System.out.println();
    }

    static class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder stringBuilder = new StringBuilder();

            if (num1 == null || num1.length() ==0) {
                return num2;
            }
            if (num2 == null || num2.length() ==0) {
                return num1;
            }
            int tail1 = num1.length() - 1;
            int tail2 = num2.length() -1;
            int num = 0;
            while (tail1 >= 0 || tail2 >= 0 || num != 0) {
                int char1 = tail1 >= 0 ? num1.charAt(tail1) - '0' : 0;
                int char2 = tail2 >= 0 ? num2.charAt(tail2) - '0' : 0;
                int sum = char1 + char2 + num;
                stringBuilder.append(sum % 10);
                num = sum / 10;
                tail1--;
                tail2--;
            }
            return stringBuilder.reverse().toString();
        }
    }
}

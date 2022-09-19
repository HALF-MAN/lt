package test;

public class P8 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("9223372036854775808"));
    }
    static class Solution {
        public int myAtoi(String s) {
            double a = 0;
            int i = 0;
            boolean negative = false;
            while (i < s.length() && s.charAt(i) == ' ') i++;
            if (i < s.length() && s.charAt(i) == '-') {
                negative = true;
                i++;
            } else if (i < s.length() && s.charAt(i) == '+') {
                i++;
            }
            while (i < s.length() && s.charAt(i) == 0 && a == 0) i++;
            while (i < s.length() && s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                a = a * 10 + (s.charAt(i) - 48);
                i++;
            }

            if (negative) {
                a = a * -1;
            }
            if (a < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (a > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int)a;
            }
        }
    }
}

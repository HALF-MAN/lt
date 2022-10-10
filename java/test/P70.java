package test;

public class P70 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(4));
    }
    static class Solution {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            } else {
                int pre = 2;
                int before_pre = 1;
                for (int i = 2; i < n; i++) {
                    int current = pre + before_pre;
                    before_pre = pre;
                    pre = current;
                }
                return pre;
            }
        }
    }
}

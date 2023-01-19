package test;

public class P69 {
    static class Solution {
        public int mySqrt(int x) {
            int left = 0;
            int right = x;
            int ans = -1;
            while (left <= right) {
                int mid =  left + (right - left)  / 2;
                if ((long) mid * mid <= x) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.mySqrt(2);
        }
    }
}

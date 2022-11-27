package test;

public class P5 {

    public static void main(String[] args) {
        String a = "babad";
        Solution solution = new Solution();
        solution.longestPalindrome2(a);
    }
    /**
     * 中心扩散
     */
    static class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int maxStart = 0; int maxEnd = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expand(s, i, i);
                int len2 = expand(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > maxEnd - maxStart) {
                    maxStart = i - (len - 1) / 2;
                    maxEnd = i + (len) / 2;
                }
            }
            return s.substring(maxStart, maxEnd + 1);
        }

        public int expand(String s, int left, int right) {
            while (left >=0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                left --;
                right++;
            }
            return  right - left  - 1;
        }

        /**
         * 动态规划
         * @param s
         * @return
         */
        public String longestPalindrome2(String s) {
            if (s == null || s.length() < 2) {
                return s;
            }
            int maxStart = 0;
            int maxEnd = 0;
            int maxLen = 1;
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int r = 1; r < s.length(); r++) {
                for(int l = 0; l < r; l++) {
                    if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l+1][r-1])) {
                        dp[l][r] = true;
                        if (r - l + 1 > maxLen) {
                            maxStart = l;
                            maxEnd = r;
                            maxLen = r - l + 1;
                        }
                    }
                }
            }
            return s.substring(maxStart, maxEnd + 1);
        }
    }
}

package test;

import java.util.Arrays;

public class P300 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {0,1,0,3,2,3};
        int i = solution.lengthOfLIS(a);
        System.out.println();
    }

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) return 0;
            int result = 0;
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                result = Math.max(result, dp[i]);
            }

            return result;
        }
    }
}

package test;

public class P53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int pre = Integer.MIN_VALUE;
            int result = nums[0];
            for(int num : nums) {
                pre = Math.max(pre + num, num);
                result = Math.max(result, pre);
            }
            return result;
        }
    }
}

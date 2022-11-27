package test;

public class P153 {

    class Solution {
        public int findMin(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while ( l < r) {
                int m = (r - l) / 2 + l;
                if (nums[m] < nums[r]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return nums[l];
        }
    }
}

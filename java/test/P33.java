package test;

public class P33 {
    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] nums = new int[]{4,5,6,7,0,1,2};
            solution.search(nums, 0);
        }
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] >= nums[0]) {
                    if (nums[0] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[nums.length - 1] >= target && target > nums[mid]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}

package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1 {

    public static void main(String[] args) {
        int[] a = {3,2,4};
        Solution solution = new Solution();
        solution.twoSum(a, 6);
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i =0; i < nums.length; i++) {
                if (map.containsKey(target-nums[i])) {
                    return new int[]{map.get(target-nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }
}

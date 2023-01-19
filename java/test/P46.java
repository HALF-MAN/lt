package test;

import java.util.ArrayList;
import java.util.List;

public class P46 {
    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.permute(new int[]{1,2,3});
        }
        public List<List<Integer>> permute(int[] nums) {
            boolean[] visited = new boolean[nums.length];
            List<List<Integer>> result = new ArrayList<>();
            recurve(nums, visited, new ArrayList<>(), result);
            return result;
        }
        void recurve(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
            if (list.size() == nums.length) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(nums[i]);
                    recurve(nums, visited, list, result);
                    visited[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}

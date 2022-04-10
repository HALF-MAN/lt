package Combination_Sum_39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        comSum(candidates, target, 0, 0);
        return result;
    }
    public void comSum(int[] candidates, int target, int curIndex, int curSum) {
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = curIndex; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            comSum(candidates, target, i, curSum + candidates[i]);
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,6,7};
        Solution solution = new Solution();
        solution.combinationSum(a, 7);
        System.out.println();
    }
}

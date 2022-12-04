package test;

import java.util.ArrayList;
import java.util.List;

public class P442 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> ret = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i , nums[i] - 1);
                }
            }
            for (int i = 0; i < n; i++) {
                if (i != nums[i] - 1) {
                    ret.add(nums[i]);
                }
            }
            return ret;
        }

        public void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }


    }
}

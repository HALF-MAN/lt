package test;

import java.util.Random;


public class P215 {
    Random random = new Random();

    public static void main(String[] args) {
        int[] nums ={3,2,1,5,6,4};
        int k = 2;
        Solution solution = new Solution();
        int kthLargest = solution.findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
    static class Solution {
        Random random = new Random();
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, k);
        }

        public int quickSelect(int[] nums, int l, int r, int k) {
            int index = partition(nums, l, r);
            if (index == nums.length - k) {
                return nums[index];
            } else if (index > nums.length - k) {
                return quickSelect(nums, l, index - 1, k);
            } else {
                return quickSelect(nums, index + 1, r, k);
            }
        }

        public int partition(int[] nums, int l, int r) {
            int randomIndex = random.nextInt(r - l + 1) + l;
            swap(nums, l, randomIndex);
            int j = l;
            int pivot = nums[l];
            for (int i = l + 1; i <= r; i++) {
                if (pivot >= nums[i]) {
                    swap(nums, ++j, i);
                }
            }
            swap(nums, j, l);
            return j;
        }

        public void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }

}

package test;

public class P912 {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        Solution solution = new Solution();
        solution.sortArray(nums);
        System.out.println();
    }
    static class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        void quickSort(int[] nums, int start, int end) {
            if (start > end) return;
            int l = start;
            int r = end;
            int mid = l + (r - l)/2;
            int n = nums[mid]; //每次去中间位置和开始位置交换一下在值，避免有序数组的递归树过度倾斜
            swap(nums, l, mid);
            while (l < r) {
                while (l < r && nums[r] >= n) r--;
                while (l < r && nums[l] <= n) l++;
                if (l < r) {
                    swap(nums, l, r);
                }
            }
            swap(nums, start, l);
            quickSort(nums, start, r - 1);
            quickSort(nums, r + 1, end);
        }

        void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }
}

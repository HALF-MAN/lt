package test;

import java.util.Arrays;

public class P88 {
    static class Solution {
        public static void main(String[] args) {
           Solution solution = new Solution();
           int[] nums1 = {4,0,0,0,0,0};
           int[] nums2 = {1,2,3,5,6};
           solution.merge(nums1, 1, nums2, 5);
           System.out.println();
        }
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if(m == 0) {
               for (int y = 0; y < n; y++) {
                   nums1[y] = nums2[y];
               }
               return;
            }
            if (n==0) {
                return;
            }
            int[] result = new int[m+n];
            int i =0, j = 0;
            int k = 0;
            while (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    result[k++] = nums1[i++];
                } else {
                    result[k++] = nums2[j++];
                }
            }
            while (i < m) {
                result[k++] = nums1[i++];
            }
            while (j < n) {
                result[k++] = nums2[j++];
            }

            //copy
            for (k = 0; k < m+n; k++) {
                nums1[k] = result[k];
            }
        }
    }
}

package test;

import java.util.Stack;

public class P42 {
    class Solution {
        //双指针
        public int trap(int[] height) {
            int left = 0,  right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            int sum = 0;
            while (left < right) {
                leftMax = Math.max(height[left], leftMax);
                rightMax = Math.max(height[right], rightMax);
                if (height[left] < height[right]) {
                    sum = sum + leftMax - height[left];
                    left++;
                } else {
                    sum = sum + rightMax - height[right];
                    right--;
                }
            }
            return sum;
        }
        //单调栈
        public int trap2(int[] height) {
            int ans = 0;
            Stack<Integer> stack = new Stack<>();
            int n = height.length;
            for (int i =0; i < n; i++) {
                while (!stack.empty() && height[i] > height[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.empty()) {
                        break;
                    }
                    int left = stack.peek();
                    int calwidth = i - left - 1;
                    int calheight = Math.min(height[left], height[i]) - height[top];
                    ans = ans + calwidth * calheight;
                }
            }
            return ans;
        }
    }
}

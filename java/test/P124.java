package test;

public class P124 {

    class Solution {
        int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);
            return max;
        }
        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftMax = Math.max(0, dfs(root.left));
            int rightMax = Math.max(0, dfs(root.right));
            max = Math.max(max, root.val + leftMax + rightMax);
            return root.val + Math.max(leftMax, rightMax);
        }
    }
}

package test;

public class P104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = root.left == null ? 0 : maxDepth(root.left);
        int rightDepth = root.right == null ? 0 : maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}

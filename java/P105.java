import test.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P105 {
    class Solution {
        public Map<Integer, Integer> indexMap;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            indexMap = new HashMap<>();
            for (int i =0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }
            return build(preorder, inorder, 0, n - 1, 0, n - 1);
        }
        public TreeNode build(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {

            if (preorderLeft > preorderRight) {
                return null;
            }

            int rootVal = preorder[preorderLeft];

            int inorderIndex = indexMap.get(rootVal);

            TreeNode root = new TreeNode(rootVal);

            int leftTreeSize = inorderIndex - inorderLeft;

            root.left = build(preorder, inorder, preorderLeft + 1, preorderLeft + leftTreeSize, inorderLeft, inorderIndex - 1);
            root.right = build(preorder, inorder, preorderLeft + leftTreeSize + 1, preorderRight, inorderIndex + 1, inorderRight);
            return root;
        }
    }
}

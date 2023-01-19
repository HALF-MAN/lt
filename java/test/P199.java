package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199 {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            if(root == null) {
                return result;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int i = 1;
                while (i <= size) {
                    TreeNode node = queue.poll();
                    if (i == 1) {
                        result.add(node.val);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    i++;
                }
            }
            return result;
        }
    }
}

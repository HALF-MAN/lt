package test;
import java.util.*;

public class P103 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> nodeList = new LinkedList<>();
            nodeList.offer(root);
            boolean left = true;
            while (!nodeList.isEmpty()) {
                Deque<Integer> list = new LinkedList<>();
                int size = nodeList.size(); //要提前把当前层的size记录一下
                for (int i = 0; i < size; i++) { //用带i的这种方式遍历，不能用带迭代器的方式遍历，会引起修改异常
                    TreeNode node = nodeList.poll();
                    if (left) {
                        list.offerLast(node.val);
                    } else {
                        list.addFirst(node.val);
                    }
                    if (null != node.left) {
                        nodeList.offer(node.left);
                    }
                    if (null != node.right) {
                        nodeList.offer(node.right);
                    }
                }
                result.add(new ArrayList<>(list));
                left = !left;
            }
            return result;
        }
    }
}

# Definition for a binary tree node.
from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        self.list = []
        self.inorder(root)
        return self.list
    def inorder(self, root: TreeNode):
        if not root:
            return
        self.inorder(root.left)
        self.list.append(root.val)
        self.inorder(root.right)
if __name__ == "__main__":
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)
    s = Solution()
    s.inorderTraversal(root)
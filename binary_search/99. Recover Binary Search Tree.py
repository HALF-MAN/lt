# Definition for a binary tree node.
import sys
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.prev = TreeNode(-sys.maxsize-1)
        self.first, self.second = None, None
        self.inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val
    def inorder(self, root):
        if not root:
            return 
        self.inorder(root.left)
        if root.val < self.prev.val:
                self.first = self.prev if not self.first else self.first
                self.second = root
        self.prev = root
        self.inorder(root.right)
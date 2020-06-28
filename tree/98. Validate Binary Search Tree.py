# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.validBst(root, None, None)
    def validBst(self, root: TreeNode, min: TreeNode, max: TreeNode) -> bool:
        if not root:
            return True
        if min != None and root.val <= min.val:
            return False
        if max != None and root.val >= max.val:
            return False
        return self.validBst(root.left, min, root) and self.validBst(root.right, root, max)
            
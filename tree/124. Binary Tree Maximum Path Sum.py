# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        ans = float('-inf') 
        def getMaxSum(root: TreeNode):
            nonlocal ans
            if not root:
                return 0
            left = max(0, getMaxSum(root.left))
            right = max(0, getMaxSum(root.right))
            ans = max(ans, left + right + root.val)
            return max(left, right) + root.val
        getMaxSum(root)
        return ans
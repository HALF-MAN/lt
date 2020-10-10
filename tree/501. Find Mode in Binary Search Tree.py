from typing import List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def findMode(self, root: TreeNode) -> List[int]:
        tmpCount = 0
        tmpMaxCount = -1;
        result = []
        pre = None
        def inorder(root:TreeNode):
            nonlocal tmpCount
            nonlocal tmpMaxCount
            nonlocal result
            nonlocal pre
            if not root:
                return
            inorder(root.left)
            tmpCount += 1
            if root.val != pre:
                pre = root.val
                tmpCount = 1
            if tmpCount > tmpMaxCount:
                tmpMaxCount = tmpCount
                result.clear()
                result.append(pre)
            elif tmpCount == tmpMaxCount:
                result.append(pre)
            inorder(root.right)
        inorder(root)
        return result
# Definition for a binary tree node.
from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        inMap = {}
        for i in range(len(inorder)):
            inMap[inorder[i]] = i 
        
        return self.build(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1, inMap)

    def build(self, preorder, preStart, preEnd, inorder, inStart, inEnd, inMap):
        if preStart > preEnd or inStart > inEnd:
            return None
        root = TreeNode(preorder[preStart])
        inRoot = inMap[root.val]
        numsLeft = inRoot - inStart
        root.left = self.build(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap)
        root.right = self.build(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap)
        return root
if __name__ == "__main__":
    s = Solution()
    t = s.buildTree([3,9,20,15,7], [9,3,15,20,7])
    pass
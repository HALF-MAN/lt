# Definition for a binary tree node.
from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        if n == 0:
            return []
        return self.buildBST(1, n)
    def buildBST(self, start, end):
        if start > end:
            return [None]
        result = []
        for i in range(start, end + 1):
            left_tree_list = self.buildBST(start, i - 1)
            right_tree_list = self.buildBST(i + 1, end)

            for j in range(len(left_tree_list)):
                for k in range(len(right_tree_list)):
                    node = TreeNode(i)
                    node.left = left_tree_list[j]
                    node.right = right_tree_list[k]
                    result.append(node)
        return result

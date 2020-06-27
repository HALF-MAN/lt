# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if not root:
            return root
        if root.val == key:
            if not root.left:
                return root.right
            if not root.right:
                return root.left
            minNode = self.getMin(root.right)
            root.val = minNode.val
            minNode.val = "null"
            root.right = self.deleteNode(root.right, minNode.val)
        elif root.val > key:
            root.left = self.deleteNode(root.left, key)
        elif root.val < key:
            root.right = self.deleteNode(root.right, key)
        return root
    def getMin(self, node :TreeNode):
        while node.left:
            node = node.left
        return  node
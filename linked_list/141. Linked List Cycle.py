# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if not head:
            return False
        fastNode = slowNode =  head
        while fastNode and fastNode.next:
            fastNode = fastNode.next.next
            slowNode = slowNode.next
            if fastNode == slowNode:
                return True
        return False
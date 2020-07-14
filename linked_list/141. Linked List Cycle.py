# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if not head:
            return False
<<<<<<< HEAD
        
=======
        fastNode = slowNode =  head
        while fastNode and fastNode.next:
            fastNode = fastNode.next.next
            slowNode = slowNode.next
            if fastNode == slowNode:
                return True
        return False
>>>>>>> dc29cf2fce77d4d75ed3e366155e5a012aa30133

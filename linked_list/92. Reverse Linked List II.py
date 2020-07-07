# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        dummy = ListNode(-1)
        dummy.next = head
        cur, prev = head, dummy
        for _ in range(m - 1):
            cur = cur.next
            prev = prev.next
        for _ in range(n - m):
            tmp = cur.next
            cur.next = tmp.next
            tmp.next = prev.next
            prev.next = tmp
        return dummy.next
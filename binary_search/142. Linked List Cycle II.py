# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        if not head:
            return None
        fast = slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                break
        else:
            return None
        while head != slow:
            slow = slow.next
            head = head.next
        return head
if __name__ == "__main__":
    t1 = ListNode(3)
    t2 = ListNode(2)
    t3 = ListNode(0)
    t4 = ListNode(-4)

    t1.next = t2
    t2.next = t3
    t3.next = t4
    t4.next = t2
    s = Solution()
    s.detectCycle(t1)
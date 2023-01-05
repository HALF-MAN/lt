package test;

import java.util.List;

public class P2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);
            ListNode pre = head;
            ListNode p = l1, q = l2;
            int tmp = 0;
            while (null != p || null != q) {
                int x = p != null ? p.val : 0;
                int y = q != null ? q.val : 0;
                int sum = x + y + tmp;
                tmp = sum / 10;
                pre.next = new ListNode(sum % 10);
                pre = pre.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (tmp > 0) {
                pre.next = new ListNode(tmp);
            }
            return head.next;
        }
    }
}

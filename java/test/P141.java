package test;

public class P141 {
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode p = head;
            if (p == null || p.next == null) {
                return false;
            }
            ListNode q = p.next.next;
            while (p != q) {
                if (q == null || q.next == null) {
                    return false;
                }
                p = p.next;
                q = q.next.next;
            }
            return true;
        }
    }
}

package test;

public class P206 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode tmp = new ListNode();
            if (head == null || head.next == null) {
                return head;
            }
            while (head != null) {
                ListNode next = head.next;
                head.next = tmp.next;
                tmp.next = head;
                head = next;
            }
            return tmp.next;
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

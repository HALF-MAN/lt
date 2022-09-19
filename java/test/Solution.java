package test;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //1->2->3->4->5
        boolean needHead = true;
        ListNode newHead = null;
        ListNode tail = new ListNode();
        ListNode current = head;
        while (current != null) {
            int i = 1;
            ListNode start = current;

            while (i <= k && current != null) {current = current.next; i++;}
            if (i > k) {
                ListNode tmpHead = new ListNode();
                while (start != current) {
                    ListNode tmp = start.next;
                    start.next = tmpHead.next;
                    tmpHead.next = start;
                    start = tmp;
                }
                if (needHead) {
                    newHead = tmpHead.next;
                    needHead = false;
                }
                tail.next = tmpHead.next;
                while (tmpHead.next != null) tmpHead = tmpHead.next;
                tail = tmpHead;
            } else {
                tail.next = start;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        Solution solution = new Solution();
        solution.reverseKGroup(listNode, 2);
    }
}

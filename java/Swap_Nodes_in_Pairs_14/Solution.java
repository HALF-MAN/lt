package Swap_Nodes_in_Pairs_14;

import java.util.List;

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

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        while (pre.next != null && pre.next.next != null) {
            ListNode tmp = pre.next;
            pre.next = tmp.next;
            tmp.next = pre.next.next;
            pre.next.next = tmp;
            pre = pre.next.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = new ListNode(3);
        b.next = c;
        ListNode d = new ListNode(4);
        c.next = d;
        Solution solution = new Solution();
        solution.swapPairs(a);
    }
}

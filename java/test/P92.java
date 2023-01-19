package test;

import java.util.List;
import java.util.Stack;

public class P92 {
    static class Solution {
        public static void main(String[] args) {
            ListNode listNode = ListNode.buildListNode(new int[]{1,2,3,4,5});
            Solution solution = new Solution();
            solution.reverseBetween(listNode, 1,4);
        }
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummyNode = new ListNode();
            dummyNode.next = head;
            ListNode pre = dummyNode;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }
            ListNode cur = pre.next;
            ListNode next;
            for (int i = 0; i < right - left; i++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            return dummyNode.next;
        }
    }
}

package test;

public class P82 {

    static class Solution {
        public static void main(String[] args) {
            ListNode listNode = ListNode.buildListNode(new int[]{1,2,3,3,4,4,5});
            Solution solution = new Solution();
            solution.deleteDuplicates1(listNode);
        }
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null && head.next == null) {
                return head;
            }
            ListNode pre = new ListNode();
            ListNode dummy = pre;
            pre.next = head;
            while (pre.next != null && pre.next.next != null) {
                if (pre.next.val == pre.next.next.val) {
                    int nexVal = pre.next.val;
                    while (pre.next != null && pre.next.val == nexVal) {
                        pre.next = pre.next.next;
                    }
                } else {
                    pre = pre.next;
                }
            }
            return dummy.next;
        }


        public ListNode deleteDuplicates1(ListNode head) {
            if(head == null && head.next == null) {
                return head;
            }
            ListNode pre = head;
            ListNode dummy = pre;
            while (pre.next != null) {
                if (pre.val == pre.next.val) {
                    int nexVal = pre.val;
                    while (pre.next != null && pre.next.val == nexVal) {
                        pre.next = pre.next.next;
                    }
                } else {
                    pre = pre.next;
                }
            }
            return dummy;
        }
    }
}

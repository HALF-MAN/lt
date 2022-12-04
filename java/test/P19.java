package test;

public class P19 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.buildListNode(new int[]{1});
        Solution solution = new Solution();
        solution.removeNthFromEnd(listNode, 2);
        System.out.println();
    }
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode first = head;
            ListNode second = dummy;
            for (int i = 0; i < n; i++) {
                first = first.next;
            }
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummy.next;
        }
    }
}

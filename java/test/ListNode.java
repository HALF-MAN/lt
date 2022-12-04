package test;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode buildListNode(int[] vals) {
        ListNode head = new ListNode(vals[0]);
        ListNode tail = head;
        for (int i = 1; i < vals.length; i++) {
            tail.next = new ListNode(vals[i]);
            tail = tail.next;
        }
        return head;
    }
}
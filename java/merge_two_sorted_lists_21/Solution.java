package merge_two_sorted_lists_21;

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode header = new ListNode();
        ListNode pre = header;
        while (null != list1 && null != list2) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        while (null != list1) {
            pre.next = list1;
            list1 = list1.next;
            pre = pre.next;
        }
        while (null != list2) {
            pre.next = list2;
            list2 = list2.next;
            pre = pre.next;
        }
        return header.next;
    }
}
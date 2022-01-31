import java.util.ArrayList;
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

class Solution {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
        ListNode current = new ListNode();
        current.val = 1;
        ListNode head = current;
        for (Integer i : list) {
            ListNode tmp  = new ListNode();
            tmp.val = i;
            current.next = tmp;
            current = tmp;
        }
        ListNode listNode = removeNthFromEnd(head, 1);
        System.out.println(1);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode end = head;
        int currNum = n;
        while(null != end) {
            if (currNum > 0) {
                currNum--;
            } else {
                pre = pre.next;
            }
            end = end.next;
        }
        if (null != pre.next && pre.next != head) {
            pre.next = pre.next.next;
            return head;
        } else {
            return head.next;
        }
    }
}
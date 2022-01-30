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
        List<Integer> list =
        [1,2,3,4,5]
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = null;
        ListNode end = head.next;
        int currNum = 0;
        while(null != end) {
            if (currNum < n) {
                currNum++;
                end = end.next;
            } else if (currNum == n) {
                pre = end;
            } else {
                pre =  pre.next;
            }
            end = end.next;
        }
        if (currNum > n) {
            pre.next = pre.next.next;
        }
        return head;
    }
}
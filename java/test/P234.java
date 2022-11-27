package test;

public class P234 {

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
    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            int len = 0;
            ListNode p = head;
            while (null !=p ) {
                len++;
                p = p.next;
            }
            p = head;
            for (int i = 1; i <= len/2; i++) {
                p = p.next;
            }
            ListNode pre = new ListNode(1);
            while (p!= null) {
                ListNode tmp = p.next;
                p.next = pre.next;
                pre.next = p;
                p = tmp;
            }
            p = pre.next;
            while (null != p) {
                if (head.val != p.val) {
                    return false;
                }
                p = p.next;
                head = head.next;
            }
            return true;
        }
    }

    static ListNode buildList(int[] arr) {
        ListNode pre = new ListNode();
        ListNode head = pre;
        for (int i = 0; i < arr.length; i++) {
            pre.next = new ListNode(arr[i]);
            pre = pre.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        Solution solution = new Solution();
        solution.isPalindrome(buildList(a));
    }
}

package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P148 {
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            ArrayList<ListNode> list = new ArrayList<>();
            while (null != head) {
               list.add(head);
               head = head.next;
            }
            Collections.sort(list, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            ListNode pre = new ListNode();
            for (ListNode node : list) {
                pre.next = node;
                pre = node;
            }
            list.get(list.size() - 1).next = null;
            return list.get(0);
        }

        //归并排序
        public ListNode sortList1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode tmp = slow.next;
            slow.next = null;
            ListNode left = sortList1(head);
            ListNode right = sortList1(tmp);
            ListNode pre = new ListNode();
            ListNode res = pre;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    pre.next = left;
                    left = left.next;
                } else {
                    pre.next = right;
                    right = right.next;
                }
                pre = pre.next;
            }
            pre.next = left != null ? left : right;
            return res.next;
        }
    }
}

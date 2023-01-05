package test;

import java.util.ArrayList;
import java.util.List;

public class P143 {

    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.reorderList(ListNode.buildListNode(new int[]{1,2,3,4}));
            System.out.println(1);
        }
        public void reorderList(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            ListNode tmp = head;
            while (null != tmp) {
                list.add(tmp);
                tmp = tmp.next;
            }
            int i = 0, j = list.size() - 1;
            while (i < j) {
                list.get(i).next = list.get(j);
                i++;
                if (i == j) {
                    break;
                }
                list.get(j).next = list.get(i);
                j--;
            }
            list.get(i).next = null;
        }
    }
}

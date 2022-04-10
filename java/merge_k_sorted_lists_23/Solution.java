package merge_k_sorted_lists_23;

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

/**
 * [[1,4,5],[1,3,4],[2,6]]
 */
public class Solution {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(4);
        ListNode list3 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;

        ListNode list4 = new ListNode(1);
        ListNode list5 = new ListNode(3);
        ListNode list6 = new ListNode(4);
        list4.next = list5;
        list5.next = list6;

        ListNode list7 = new ListNode(2);
        ListNode list8 = new ListNode(6);
        list7.next = list8;

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = list1;
        listNodes[1] = list4;
        listNodes[2] = list7;

        ListNode listNode = mergeKLists(listNodes);
        System.out.println(1);
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(null == lists) {
            return null;
        }
        ListNode header = new ListNode();
        ListNode pre = header;
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < lists.length; i++) {
            if (null == lists[i]) {
                continue;
            }
            if (minVal > lists[i].val) {
                minIndex = i;
                minVal = lists[i].val;
            }
        }
        if (-1 == minIndex || null == lists[minIndex]) {
            return null;
        }
        ListNode minValNode = lists[minIndex];
        lists[minIndex] = minValNode.next;
        minValNode.next = null;
        pre.next = minValNode;
        pre = pre.next;
        pre.next = mergeKLists(lists);
        return header.next;
    }
}

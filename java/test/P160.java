package test;

public class P160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int al = 0;
        int bl = 0;
        ListNode p = headA;
        ListNode q = headB;
        while (null != p) {
            al++;
            p = p.next;
        }
        while (null != q) {
            bl++;
            q = q.next;
        }
        if (al > bl) {
            p = headA;
            q = headB;
        } else {
            p = headB;
            q = headA;
        }
        int i = 1;
        while (i <= Math.abs(al - bl) && null !=p ) {
            p = p.next;
            i++;
        }
        while (null != p && null != q) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}

package leetCode热题100;


public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode p1 = headA, p2 = headB;
        while (p1 != null) {
            lenA++;
            p1 = p1.next;
        }
        while (p2 != null) {
            lenB++;
            p2 = p2.next;
        }
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (diff-- > 0) {
                headA = headA.next;
            }
        }
        if (lenB > lenA) {
            while (diff-- > 0) {
                headB = headB.next;
            }
        }
        while(headA!=null&&headB!=null){
            if (headA == headB){
                return headA;

            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;

    }

    public static void main(String[] args) {


    }


}




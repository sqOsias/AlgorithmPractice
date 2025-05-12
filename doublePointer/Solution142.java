package doublePointer;

import java.util.List;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution142 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
            if(slow==fast){
                ListNode p=head;
                ListNode q=fast;
                while(p!=q){
                    p=p.next;
                    q=q.next;
                }
                return p;
            }
        }
        return null;
    }
}
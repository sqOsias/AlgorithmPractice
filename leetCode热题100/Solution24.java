package leetCode热题100;

import java.lang.annotation.Target;

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while (cur.next!=null&&cur.next.next!=null){
            ListNode start = cur.next;
            ListNode end = cur.next.next;
            cur.next=end;
            start.next=end.next;
            end.next=start;
            cur=start;

        }
        return dummy.next;
    }


    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode listNode1 = solution24.swapPairs(listNode);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
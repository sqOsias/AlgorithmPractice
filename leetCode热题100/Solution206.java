package leetCode热题100;

class Solution206 {
    public ListNode reverseList(ListNode head) {

        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
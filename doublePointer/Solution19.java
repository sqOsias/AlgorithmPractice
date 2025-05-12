package doublePointer;

/**
 * /**
 *  * Definition for singly-linked list.
 *  * /
 */



class Solution19 {
    public class ListNode {

        int val;

        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        ListNode fast=dummy;
        while(n-->=0){
            fast=fast.next;
        }
        System.out.println("fast:"+fast.val);
        while(fast !=null){
            fast=fast.next;
            cur=cur.next;
        }
        if (cur.next!=null){
            cur.next=cur.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution19 solution19=new Solution19();
        ListNode head=new Solution19().new ListNode(1);
        head.next=new Solution19().new ListNode(2);
        head.next.next=new Solution19().new ListNode(3);
        head.next.next.next=new Solution19().new ListNode(4);
        head.next.next.next.next=new Solution19().new ListNode(5);
        solution19.removeNthFromEnd(head,2);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
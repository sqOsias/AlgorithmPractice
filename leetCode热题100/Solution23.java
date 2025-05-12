package leetCode热题100;

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[]lists,int l,int r){
        if(l == r){
            return lists[l];
        }
        if(l > r){
            return null;
        }
        int mid = (l+r)>>1;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    public ListNode mergeTwoLists(ListNode a, ListNode b){
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head ,aptr = a ,bptr = b;
        while (aptr != null && bptr != null) {
            if (aptr.val < bptr.val){
                cur.next = aptr;
                aptr = aptr.next;
            }else {
                cur.next = bptr;
                bptr = bptr.next;
            }
            cur = cur.next;
        }
        cur.next = aptr != null ? aptr : bptr;
        return head.next;
    }
}
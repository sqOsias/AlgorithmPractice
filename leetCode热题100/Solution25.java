package leetCode热题100;

class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head==null||head.next==null||k==1){
            return head;
        }
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        // 创建虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy; // 前一组的尾节点
        ListNode end = dummy; // 当前组的尾节点
        while(len >= k){
            end = pre;
            for(int i=0;i<k;i++){
                end=end.next;
            }
            ListNode nextGroupHead=end.next;
            ListNode[] reverseNodes = reverse(pre.next, end);
            pre.next = reverseNodes[0];
            reverseNodes[1].next = nextGroupHead;
            pre = reverseNodes[1];
            len -= k;
        }
        return dummy.next;



    }
    private ListNode[] reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode cur = start;
        ListNode next = null;
        while (prev != end) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return new ListNode[]{end, start}; // 返回翻转后的头尾节点
    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode1 = solution25.reverseKGroup(listNode, 3);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
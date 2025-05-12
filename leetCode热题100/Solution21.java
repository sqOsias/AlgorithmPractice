package leetCode热题100;

class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-2);

        ListNode listNode = new ListNode(-1);
        dummy.next = listNode;
        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                listNode.next = list1;
                list1 = list1.next;
            }else{
                listNode.next = list2;
                list2 = list2.next;
            }
            listNode = listNode.next;
        }
        while(list1 != null){
            listNode.next = list1;
            list1 = list1.next;
            listNode = listNode.next;
        }
        while(list2 != null){
            listNode.next = list2;
            list2 = list2.next;
            listNode = listNode.next;
        }
        return dummy.next.next;
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        Solution21 solution21 = new Solution21();
        ListNode listNode = solution21.mergeTwoLists(list1, list2);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
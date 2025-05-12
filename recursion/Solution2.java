package recursion;


class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value1 = getValue(l1);
        int value2 = getValue(l2);
        int sum = value1 + value2;
        return getList(sum);
    }

    public int getValue(ListNode l1) {
        int value = 0;
        while (l1 != null) {
            value = value * 10 + l1.val;
            l1 = l1.next;
        }
        return value;
    }

    public ListNode getList(int value) {
        if (value == 0) return new ListNode(0);

        ListNode dummy = new ListNode();
        ListNode current=dummy;
        while(value>0){
            current.next = new ListNode(value % 10);
            current = current.next;
            value /= 10;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
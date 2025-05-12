package leetCode热题100;

class Solution02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = list2Num(l1);
        int n2 = list2Num(l2);
        System.out.println(n1+" "+n2);
        return num2List(n1+n2);
    }

    public static int list2Num(ListNode head){
        int res=0;
        int count=0;
        while(head!=null){
            res= (int) (res+head.val*Math.pow(10,count++));
            head=head.next;
        }
        return res;
    }

    public static ListNode num2List(int num){
        if(num==0){
            return new ListNode(0);
        }
        int maxValue = Integer.MAX_VALUE;
        if (num>maxValue){
            num=num%maxValue;
        }
        ListNode head=new ListNode(0);
        ListNode cur=head;
        while(num>0){
            cur.next=new ListNode(num%10);
            cur=cur.next;
            num/=10;
        }
        return head.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head=null ,tail=null;
        int carry=0;
        while(l1!=null || l2!=null ){
            int n1 = l1!=null ? l1.val : 0;
            int n2 = l2!=null ? l2.val : 0;
            int sum= n1+n2+carry;
            if (head==null){
                head=tail=new ListNode(sum%10);
            }else{
                tail.next=new ListNode(sum%10);
                tail=tail.next;
            }
            carry=sum/10;
            if (l1!=null) l1=l1.next;
            if (l2!=null) l2=l2.next;
        }
        if (carry>0){
            tail.next=new ListNode(carry);
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = new Solution02().addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        ListNode res2 = new Solution02().addTwoNumbers(l3, l4);
        while (res2 != null) {
            System.out.println(res2.val);
            res2 = res2.next;
        }

    }


}
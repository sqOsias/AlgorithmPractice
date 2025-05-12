package leetCode热题100;


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node dummy = new Node(0);
        dummy.next = head;
        Node newDummy = new Node(0);
        Node newHead=new Node(head.val);
        newDummy.next = newHead;
        head=head.next;
        while (head != null) {
//            newHead.next = new Node(head.val);

            Node temp = newDummy.next;
            boolean isExist=false;
            while (temp != null) {
                if (temp.random==head){
                    newHead.next=temp.random;
                    isExist=true;
                    break;
                }
                temp = temp.next;
            }
            if (!isExist){
                newHead.next = new Node(head.val);
            }



            if (head.random != null){

                boolean flag=false;
                temp=newDummy.next;
                while (temp != null) {
                    if (temp == head.random) {
                        flag = true;
                        break;
                    }
                    temp = temp.next;
                }
                if (flag) {
                    newHead.random = temp;
                }else{
                    newHead.random = new Node(head.random.val);
                }
            }else{
                newHead.random = null;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return newDummy.next;


    }
    public Node copyRandomList1(Node head) {
        if (head == null) return null;

        // 使用哈希表存储原节点和新节点的映射关系
        Map<Node, Node> map = new HashMap<>();

        // 第一次遍历：复制节点并建立映射关系
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // 第二次遍历：设置 next 和 random 指针
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head); // 返回新链表的头节点
    }

    public static void main(String[] args) {
        Solution138 solution138 = new Solution138();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        Node node = solution138.copyRandomList(node1);
        while (node != null) {
            System.out.println( "node.val="+node.val+" "+(node.random==null?0:node.random.val));
            node = node.next;
        }


    }
}


















package LingSingleStack.one;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个长度为 n 的链表 head
 * <p>
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * <p>
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 */
class Solution1019 {
    int n = 0;

    public int[] nextLargerNodes(ListNode head) {
        head = reverseList(head);
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            while (!stack.isEmpty() && cur.val >= stack.peek()) {
                stack.pop();
            }
            ans[--n] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(cur.val);
        }
        return ans;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n++;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        Solution1019 s = new Solution1019();
        int[] ans = s.nextLargerNodes(head);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}




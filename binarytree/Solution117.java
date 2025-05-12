package binarytree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//
//填充每个节点的下一个右侧节点指针
//填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
//初始状态下，所有 next 指针都被设置为 NULL。
class Solution117 {
    public Node connect(Node root) {

        List<Node> path;
        if (root == null) {
            return null;
        }
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            path = new ArrayList<>();
            int len = que.size();
            while (len > 0) {
                Node poll = que.poll();
                path.add(poll);
                if (poll.left != null) que.add(poll.left);
                if (poll.right != null) que.add(poll.right);
                len--;
            }
            for (int i = 0; i < path.size(); i++) {
                path.get(i).next = i == path.size() - 1 ? null : path.get(i + 1);
            }
        }
        return root;
    }
}
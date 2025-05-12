package binarytree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution429 {


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>path=new ArrayList<>();
        if (root==null){
            return res;
        }

        Queue<Node>que=new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()){
            path=new ArrayList<>();
            int len=que.size();
            while (len>0){
                Node poll = que.poll();
                path.add(poll.val);
                if(poll.children!=null){
                    for (Node node : poll.children) {
                        que.offer(node);
                    }
                }
                len--;
            }
            res.add(path);
        }

        return res;


    }
}
package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution116 {
    public Node connect(Node root) {
        List<Node> path;
        if (root==null){
            return null;
        }
        Queue<Node> que=new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            path=new ArrayList<>();
            int len = que.size();
            while(len>0){
                Node poll = que.poll();
//                path.add(poll);
                if(path.size()==0){
                    path.add(poll);
                }else if (len >1){
                    path.get(path.size()-1).next=poll;
                    path.add(poll);
                }else if(len==1){
                    path.get(path.size()-1).next=poll;
                    path.add(poll);
                    path.get(path.size()-1).next=null;

                }
                if (poll.left!=null) que.add(poll.left);
                if (poll.right!=null) que.add(poll.right);
                len--;
            }
        }
        return root;
    }
}
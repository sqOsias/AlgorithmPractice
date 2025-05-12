package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution515 {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer>path=new ArrayList<>();
        if (root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){

            int max=Integer.MIN_VALUE;
            int len =que.size();
            while(len>0){
                TreeNode poll = que.poll();
                max=Math.max(max,poll.val);
                if (poll.left!=null) que.add(poll.left);
                if (poll.right!=null) que.add(poll.right);
                len--;
            }
            path.add(max);
        }
        return path;
    }
}
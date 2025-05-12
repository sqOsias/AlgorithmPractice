package binarytree;

import java.util.*;


class Solution102 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>path=new ArrayList<>();

        Queue<TreeNode>que=new LinkedList<>() ;
        if (root==null) return res;
        que.offer(root);

        while (!que.isEmpty()){
            path=new ArrayList<>();
            int len =que.size();

            while(len>0){
                TreeNode poll = que.poll();
                path.add(poll.val);
                if (poll.left!=null) que.add(poll.left);
                if (poll.right!=null) que.add(poll.right);
                len--;
            }
            res.add(path);
        }

        return res;
    }
}
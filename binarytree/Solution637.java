package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        int sum=0;

        if (root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int len=que.size();
            int count=que.size();
            sum=0;
            while (len>0){
                TreeNode poll = que.poll();
                sum+=poll.val;
                if (poll.left!=null) que.add(poll.left);
                if (poll.right!=null) que.add(poll.right);
                len--;
            }
            res.add(sum/(double)count);
        }

        return res;


    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(9);
        TreeNode node3=new TreeNode(20);
        TreeNode node4=new TreeNode(15);
        TreeNode node5=new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        System.out.println(new Solution637().averageOfLevels(node1));
    }
}
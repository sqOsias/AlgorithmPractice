package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>path=new ArrayList<>();

        Queue<TreeNode>que=new LinkedList<>() ;
        if (root==null) return new ArrayList<>();
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
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < res.size(); i++) {
            result.add(res.get(i).get(res.get(i).size()-1));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);

        node1.left=node2;
        node1.right=node3;
        node2.right=node5;
        node3.right=node4;

        System.out.println(new Solution199().rightSideView(node1));



    }
}
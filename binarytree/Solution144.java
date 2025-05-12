package binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution144 {
    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        preorder(root,res);
        return res;

    }

    public void preorder(TreeNode root, List<Integer> res){
        if (root==null) return;
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }


    // 迭代
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode node =root;
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                res.add(node.val);
                stack.push(node);
                node=node.left;
            }
            node = stack.pop();
            node=node.right;
        }
        return res;

    }
}
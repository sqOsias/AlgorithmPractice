package binarytree;

import backtracking.Solution;

import java.util.ArrayList;

class Solution98 {

     long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean left=isValidBST(root.left);
        if(root.val>pre) {
            pre=root.val;
        }else return false;
        boolean right=isValidBST(root.right);
        return left&&right;

    }
    ArrayList<Integer>res=new ArrayList<>();
    public void traversal(TreeNode root){
        if (root==null) return;
        traversal(root.left);
        res.add(root.val);
        traversal(root.right);
    }

    public boolean isValidBST1(TreeNode root) {
        traversal(root);
        for (int i = 0; i < res.size()-1; i++) {
            if (res.get(i)>=res.get(i+1)){
                return false;
            }
        }
        return true;


    }


    public static void main(String[] args) {
        Solution98 solution = new Solution98();

        TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(solution.isValidBST(treeNode));

        TreeNode treeNode1 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println(solution.isValidBST(treeNode1));
    }
}
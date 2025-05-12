package binarytree;

import java.util.ArrayList;

class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        traversal(root);
        for (int i = 0; i < list.size()-1; i++) {
            min=Math.min(min,list.get(i+1)-list.get(i));
        }
        return min;
    }

    ArrayList<Integer> list = new ArrayList();
    public void traversal(TreeNode root){
        if (root==null)return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}


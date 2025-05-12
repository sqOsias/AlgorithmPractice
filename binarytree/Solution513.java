package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution513 {

    int maxDepth =-1;
    int value=0;
    public int findBottomLeftValue(TreeNode root) {
        traversal(root,0);
        return value;

    }
    public void traversal(TreeNode root,int deep){
        if (root==null) return;
        if (root.left==null&&root.right==null){
            if (deep>maxDepth){
                maxDepth=deep;
                value=root.val;
            }
        }
        if (root.left!=null) traversal(root.left,deep+1);
        if (root.right!=null)traversal(root.right,deep+1);
    }
}
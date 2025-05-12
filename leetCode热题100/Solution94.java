package leetCode热题100;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root==null){
            return result;
        }
        if (root.left!=null){
            result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if (root.right!=null){
            result.addAll(inorderTraversal(root.right));
        }
        return result;

    }
}
package leetCode热题100;

import java.util.ArrayList;
import java.util.List;

class Solution114 {
    public void flatten(TreeNode root) {
        TreeNode res = root;

        List<TreeNode> list = preorder(root);
        for (int i = 1; i < list.size(); i++) {
            res.left=null;
            res.right=list.get(i);
            res=res.right;
        }
    }

    public List<TreeNode> preorder(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        res.add(root);
        res.addAll(preorder(root.left));
        res.addAll(preorder(root.right));
       return res;


    }
}
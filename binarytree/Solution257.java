package binarytree;

import java.util.ArrayList;
import java.util.List;

class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null){
            return null;
        }
        List<String> res = new ArrayList<>();
        traversal(root,new ArrayList<>(),res);
        return res;
    }

    public void traversal(TreeNode root, List<Integer>paths, List<String> res) {

        paths.add(root.val);
        if(root.left==null&&root.right==null){
            StringBuffer sv = new StringBuffer();
            for (int i = 0; i < paths.size()-1; i++) {
                sv.append(paths.get(i)).append("->");
            }
            sv.append(paths.get(paths.size()-1));
            res.add(sv.toString());
            return;
        }
        if (root.left!=null){
            traversal(root.left,paths,res);
            paths.remove(paths.size()-1);
        }
        if (root.right!=null){
            traversal(root.right,paths,res);
            paths.remove(paths.size()-1);
        }
    }
}
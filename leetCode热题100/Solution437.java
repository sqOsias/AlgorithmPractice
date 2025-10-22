package leetCode热题100;

import java.util.ArrayList;
import java.util.List;

class Solution437 {


    int res=0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }
    public void dfs(TreeNode root, int targetSum){
        if (root == null) {
            return ;
        }
        backingTracking(root, targetSum);

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

    }

    public void backingTracking(TreeNode root, long left) {
        if (root == null) {
            return ;
        }

        left -= root.val;
        if (left==0) {
            res++;
        }
        backingTracking(root.left, left);
        backingTracking(root.right, left);


    }


    public static void main(String[] args) {



    }

}
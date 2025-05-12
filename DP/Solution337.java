package DP;

/**
 * Definition for a binary tree node.
 */

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }



class Solution337 {
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            return root.val;
        }
        int val1=root.val,val2=0;
        if (root.left!=null){
            val1+=rob(root.left.left)+rob(root.left.right);
        }
        if (root.right!=null){
            val1+=rob(root.right.left)+rob(root.right.right);
        }
        val2+=rob(root.left)+rob(root.right);
        return Math.max(val1,val2);

    }

    public int rob1(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] res = robAction(root);
        return Math.max(res[0],res[1]);

    }

    public int[] robAction(TreeNode root){
        int res[]=new int[2];
        if (root==null){
            return res;
        }
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        res[0]= Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1] = root.val+left[0]+right[0];
        return res;
    }

    public static void main(String[] args) {
        Solution337 solution337 = new Solution337();
        int rob = solution337.rob1(new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1))));
        System.out.println(rob);

    }
}
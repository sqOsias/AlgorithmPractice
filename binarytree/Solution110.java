package binarytree;

class Solution110 {
    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        return height != -1;

    }
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if(leftHeight==-1){
            return -1;
        }

        int rightHeight = getHeight(root.right);
        if(rightHeight==-1){
            return -1;
        }
        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}
package binarytree;


//给定一个二叉树 root ，返回其最大深度。
//
//二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args) {
        Solution104 solution104 = new Solution104();
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int i = solution104.maxDepth(treeNode);
        System.out.println(i);
    }
}
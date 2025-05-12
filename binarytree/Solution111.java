package binarytree;


//给定一个二叉树，找出其最小深度。
//最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//说明：叶子节点是指没有子节点的节点。
class Solution111 {
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            return 1;
        }
        int min=Integer.MAX_VALUE;
        if (root.left!=null){
            min=Math.min(minDepth(root.left),min);
        }
        if (root.right!=null){
            min=Math.min(minDepth(root.right),min);
        }
        return min+1;

    }

    public static void main(String[] args) {
        Solution111 solution111 = new Solution111();
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int i = solution111.minDepth(treeNode);
        System.out.println(i);
        TreeNode treeNode1 = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));
        int i1 = solution111.minDepth(treeNode1);
        System.out.println(i1);
    }
}
package binarytree;


import java.util.Stack;

class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int leftValue=sumOfLeftLeaves(root.left );
        int rightValue=sumOfLeftLeaves(root.right);

        int midValue=0;
        if (root.left!=null&&root.left.left==null&&root.left.right==null){
            midValue=root.left.val;
        }
        return leftValue+rightValue+midValue;
    }

    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode>stack = new Stack<>();
        stack.push(root);
        int res=0;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left!=null&&node.left.left==null&&node.left.right==null){
                res+=node.left.val;
            }
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution404 solution404 = new Solution404();
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int i = solution404.sumOfLeftLeaves(treeNode);
        System.out.println(i);
    }
}
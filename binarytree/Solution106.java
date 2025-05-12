package binarytree;

class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0||postorder.length==0){
            return null;
        }
        return buildTree(inorder,postorder,0,inorder.length,0,postorder.length);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder,int inStart,int inEnd,int postStart,int postEnd){
        if(postStart==postEnd){
            return null;
        }
        int rootVal=postorder[postEnd-1];
        TreeNode root=new TreeNode(rootVal);
        int middleIndex;
        for (middleIndex=inStart;middleIndex<inEnd;middleIndex++){
            if (inorder[middleIndex]==rootVal){
                break;
            }
        }
        int leftInStart=inStart;
        int leftInEnd=middleIndex;
        int rightInorderStart=middleIndex+1;
        int rightInorderEnd=inEnd;
        int leftPostStart=postStart;
        int leftPostEnd=postStart+(middleIndex-inStart);
        int rightPostStart=leftPostEnd;
        int rightPostEnd=postEnd-1;
        root.left=buildTree(inorder,postorder,leftInStart,leftInEnd,leftPostStart,leftPostEnd);
        root.right=buildTree(inorder,postorder,rightInorderStart,rightInorderEnd,rightPostStart,rightPostEnd);
        return root;
    }
}
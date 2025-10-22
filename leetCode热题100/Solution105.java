package leetCode热题100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution105 {
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0||inorder.length==0){
            return null;
        }
        map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);


    }
    public TreeNode buildTree(int[] preorder, int[] inorder,int preStart,int preEnd,int inStart,int inEnd){
        if (preStart>preEnd||inStart>inEnd){
            return null;
        }
        int top = preorder[preStart];
        TreeNode root=new TreeNode(top);
        Integer inorderTop = map.get(top);
        root.left=buildTree(preorder,inorder,preStart+1,preStart+inorderTop-inStart,inStart,inorderTop-1);
        root.right=buildTree(preorder,inorder,preStart+inorderTop-inStart+1,preEnd,inorderTop+1,inEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution105 solution105 = new Solution105();
        TreeNode treeNode = solution105.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
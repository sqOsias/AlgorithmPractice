package binarytree;

import java.util.Arrays;

class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode node = new TreeNode();
        if (nums.length==1){
            node.val = nums[0];
            return node;
        }

        int maxValue=0;
        int maxIndex=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>maxValue){
                maxValue=nums[i];
                maxIndex=i;
            }
        }
        node.val=maxValue;
        if (maxIndex>0){
            node.left=constructMaximumBinaryTree(
                    Arrays.copyOfRange(nums,0,maxIndex));
        }
        if (maxIndex<nums.length-1){
            node.right=constructMaximumBinaryTree(
                    Arrays.copyOfRange(nums,maxIndex+1,nums.length));
        }
        return node;

    }
}
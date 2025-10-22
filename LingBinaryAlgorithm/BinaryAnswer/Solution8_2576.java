package LingBinaryAlgorithm.BinaryAnswer;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 一开始，所有下标都没有被标记。你可以执行以下操作任意次：
 * 选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。
 * 请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。
 */
class Solution8_2576 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length/2+1;
        while(left +1 <right){
            int mid = (left + right)>>>1;
            if(check(mid,nums)){
                left = mid ;
            }else{
                right = mid;
            }
        }
        return left*2 ;
    }

    public boolean check(int index,int[] nums){
        for (int i =0;i<index;i++){
            if(nums[i] * 2 > nums[nums.length-index+i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {9,2,5,4};
        Solution8_2576 solution = new Solution8_2576();
        System.out.println(solution.maxNumOfMarkedIndices(nums));
    }
}
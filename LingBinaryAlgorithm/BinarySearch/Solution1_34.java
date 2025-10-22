package LingBinaryAlgorithm.BinarySearch;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
class Solution1_34 {
    public int[] searchRange(int[] nums, int target) {
       int start = lowerBound(nums,target);
       if (start == nums.length || nums[start] != target){
           return new int[]{-1,-1};
       }
       int end = lowerBound(nums,target+1)-1;
       return new int[]{start,end};

    }


    // lowerBound 返回最小的满足 nums[i] >= target 的下标 i
    // 如果数组为空，或者所有数都 < target，则返回 nums.length
    // 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]

    private int lowerBound(int[] nums,int target){
        int left=-1,right=nums.length;
        while(left+1<right){
            int mid = left + (right-left)/2;
            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid;
            }

        }
        //right 就是第一个 >= target 的元素下标
        return right;
    }

    public static void main(String[] args) {
        Solution1_34 solution34 = new Solution1_34();
        int[] ints = new int[]{solution34.lowerBound(new int[]{1,5, 7, 7, 8, 8, 10}, 8)};
        System.out.println(Arrays.toString(ints));
    }

}
package LingBinaryAlgorithm.BinarySearch;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。
 * 如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：
 * 0 <= i < j < n，且
 * lower <= nums[i] + nums[j] <= upper
 */
class Solution10_2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            int right = lowerBound(nums,i,upper-nums[i]);
            int left = lowerBound(nums,i,lower-nums[i]-1);
            ans += right-left;
        }
        return ans;
    }

    public int lowerBound(int[]nums,int right,int target){
        int left=-1;
        while(left+1<right){
            int mid = left + (right-left)/2;
            if(nums[mid]>target){
                right=mid;
            }else{
                left=mid;
            }
        }
        return right;
    }
}
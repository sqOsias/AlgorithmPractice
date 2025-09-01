package LingBinaryAlgorithm.BinaryAnswer;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
 * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 */
class Solution8_2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = lowerBound(nums, queries[i]);
        }
        return res;

    }

    public int lowerBound(int[] nums, int target){
        int left =-1,right = nums.length;
        while(left+1<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid;
            }else{
                left=mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        Solution8_2389 solution = new Solution8_2389();
        int[] res = solution.answerQueries(nums, queries);
        for (int i = 0; i < res.length; i++) {
            System.out.print(Arrays.toString(res));
        }
    }
}
package LingBinaryAlgorithm.BinarySearch;

import java.util.Arrays;

/**
 * 给你一个二维整数数组 items ，其中 items[i] = [pricei, beautyi] 分别表示每一个物品的 价格 和 美丽值 。
 * 同时给你一个下标从 0 开始的整数数组 queries 。对于每个查询 queries[j] ，
 * 你想求出价格小于等于 queries[j] 的物品中，最大的美丽值 是多少。如果不存在符合条件的物品，那么查询的结果为 0 。
 * 请你返回一个长度与 queries 相同的数组 answer，其中 answer[j]是第 j 个查询的答案。
 */
class Solution11_2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items,(a, b) -> a[0] - b[0]);
        for (int i=1;i<items.length;i++){
            items[i][1]= Math.max(items[i][1], items[i-1][1]);
        }
        int[] ans = new int[queries.length];
        for (int i=0;i<queries.length;i++){
            int j = lowerBound(items, queries[i]);
            ans[i]= j>0? items[j-1][1]:0;
        }
        return ans;
    }

    public int lowerBound(int[][] nums, int target) {
        int left = -1, right = nums.length;
        while (left +1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid][0] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[] queries = {1,2,3,4,5,6};
        Solution11_2070 solution = new Solution11_2070();
        int[] ans = solution.maximumBeauty(items, queries);
        for (int i:ans){
            System.out.print(i+" ");
        }
    }
}
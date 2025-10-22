package LingTwoNoFixedLengthSlipWindow;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
 *
 * 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
 *
 * 子数组 是原数组中一段连续 非空 的元素序列。
 */
class Solution20_2537 {
    public long countGood(int[] nums, int k) {
        long res=0;
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int left = 0, right =0 ;right<nums.length;right++){
            Integer c = map.getOrDefault(nums[right], 0);
            cnt+=c;
            map.put(nums[right], c+1);
            while (cnt >= k){
                Integer cx = map.get(nums[left]);
                cnt-=cx-1;
                map.put(nums[left], cx-1);
                left++;
            }
            res += left;

        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,4,3,2,2,4};
        int k = 2;
        Solution20_2537 s = new Solution20_2537();
        System.out.println(s.countGood(nums, k));
    }
}
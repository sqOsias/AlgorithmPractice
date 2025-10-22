package LingTwoNoFixedLengthSlipWindow;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个 正整数 k 。
 *
 * 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
 *
 * 子数组是数组中的一个连续元素序列。
 * 输入：nums = [1,3,2,3,3], k = 2
 * 输出：6
 * 解释：包含元素 3 至少 2 次的子数组为：[1,3,2,3]、[1,3,2,3,3]、[3,2,3]、[3,2,3,3]、[2,3,3] 和 [3,3]
 */
class Solution17_2962 {
    public long countSubarrays(int[] nums, int k) {
        int target =0;
        for(int num:nums){
            target = Math.max(target,num);
        }
        long res=0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        cnt.put(target,0);
        for (int left = 0, right =0 ;right<nums.length;right++){
            cnt.merge(nums[right],1,Integer::sum);
            while(cnt.get(target)>=k){
                cnt.merge(nums[left],-1,Integer::sum);
                left++;
            }
            res += left;
        }
        return res;
    }
    // 不用map 时间缩短很多
    public long countSubarrays2(int[] nums, int k) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        long ans = 0;
        int cntMx = 0, left = 0;
        for (int x : nums) {
            if (x == mx) {
                cntMx++;
            }
            while (cntMx == k) {
                if (nums[left] == mx) {
                    cntMx--;
                }
                left++;
            }
            ans += left;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1,4,2,1};
        int k = 3;
        Solution17_2962 s = new Solution17_2962();
        System.out.println(s.countSubarrays(nums, k));
    }
}
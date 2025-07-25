package noFixedLengthSlipWindow;

import java.util.TreeMap;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。nums 的一个子数组如果满足以下条件，那么它是 不间断 的：
 *
 * i，i + 1 ，...，j  表示子数组中的下标。对于所有满足 i <= i1, i2 <= j 的下标对，都有 0 <= |nums[i1] - nums[i2]| <= 2 。
 * 请你返回 不间断 子数组的总数目。
 *
 * 子数组是一个数组中一段连续 非空 的元素序列。
 */
class Solution24_2762 {
    public long continuousSubarrays(int[] nums) {
        long res= 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int left = 0, right = 0; right < nums.length; right++) {
            map.merge(nums[right], 1, Integer::sum);
            while (map.lastKey() - map.firstKey() > 2) {
                map.merge(nums[left], -1, Integer::sum);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 4};
        Solution24_2762 s = new Solution24_2762();
        System.out.println(s.continuousSubarrays(nums));
    }
}
package noFixedLengthSlipWindow;

/**
 * 给你一个由 正 整数组成的数组 nums 。
 * <p>
 * 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
 * <p>
 * 子数组中 不同 元素的数目等于整个数组不同元素的数目。
 * 返回数组中 完全子数组 的数目。
 * <p>
 * 子数组 是数组中的一个连续非空序列。
 * 输入：nums = [1,3,1,2,2]
 * 输出：4
 * 解释：完全子数组有：[1,3,1,2]、[1,3,1,2,2]、[3,1,2] 和 [3,1,2,2] 。
 */
class Solution19_2799 {
    public int countCompleteSubarrays(int[] nums) {
        int res = 0;
        int amt = 0;
        int amount = 0;
        boolean[] flag = new boolean[10001];

        int[] cnt = new int[10001];
        for (int num : nums) {
            if (!flag[num]) {
                amt++;
                flag[num] = true;
            }
        }
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (cnt[nums[right]] == 0) {
                amount++;
            }
            cnt[nums[right]]++;
            while (amount == amt) {
                cnt[nums[left]]--;
                if (cnt[nums[left]] == 0) {
                    amount--;
                }
                left++;
            }
            res += left;

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 2};
        System.out.println(new Solution19_2799().countCompleteSubarrays(nums));
    }
}
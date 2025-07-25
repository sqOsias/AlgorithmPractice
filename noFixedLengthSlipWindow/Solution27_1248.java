package noFixedLengthSlipWindow;

/**
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中 「优美子数组」 的数目。
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 */
class Solution27_1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int cnt1 = 0, cnt2 = 0;
        int[]ans = new int[2];
        for (int left = 0, right = 0; right < nums.length; right++){
            ans[nums[right] % 2]++;
            while(ans[1]>=k){
                ans[nums[left] % 2]--;
                left++;
            }
            cnt1 += left;
        }
        ans = new int[2];
        for (int left = 0, right = 0; right < nums.length; right++){
            ans[nums[right] % 2]++;
            while(ans[1]>=k+1){
                ans[nums[left] % 2]--;
                left++;
            }
            cnt2 += left;
        }
        return cnt1-cnt2;

    }
}
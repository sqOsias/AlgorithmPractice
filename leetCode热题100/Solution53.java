package leetCode热题100;

class Solution53 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int ans = nums[0];
        for (int num : nums) {
            pre = Math.max(num , pre + num);
            ans = Math.max(ans , pre);
        }
        return ans;
    }
}
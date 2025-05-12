package DP;

class Solution377 {
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i =1;i<=target;i++){
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j]>=0){
                    dp[i] += dp[i - nums[j]];
                }

            }
        }
        return dp[target];

    }
    public int combinationSum41(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        Solution377 s = new Solution377();
        System.out.println(s.combinationSum4(nums, target));
    }
}
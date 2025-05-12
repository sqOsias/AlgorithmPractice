package DP;

import static java.lang.Math.pow;

class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }


        if(sum < Math.abs(target)){
            return 0;
        }

        if((sum + target) % 2 != 0) {
            return 0;
        }

        int left = (sum + target) / 2;


        int[][] dp = new int[nums.length][left + 1];

        if (nums[0] <= left) {
            dp[0][nums[0]] = 1;
        }

        int numZeros = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                numZeros++;
            }
            dp[i][0] = (int) Math.pow(2, numZeros);

        }

        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j <= left; j++) {
                if(nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }


        return dp[nums.length - 1][left];
    }
}
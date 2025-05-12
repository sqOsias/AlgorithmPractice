package DP;

class Solution673 {
    public int findLengthOfLCIS(int[] nums) {


        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]> nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            result = Math.max(result, dp[i]);

        }

        return result;

    }

    public int greedy(int[] nums){
        if (nums.length<=1){
            return nums.length;
        }
        int result=1;
        int count=1;

        for (int i = 1; i < nums.length; i++){
            if(nums[i]>nums[i-1]){
                count++;
                result=Math.max(result,count);
            }else {
                count=1;
            }

        }
        return result;

    }

    public static void main(String[] args) {
        Solution673 solution673 = new Solution673();
        int i = solution673.greedy(new int[]{1, 3, 5, 4, 7});
        System.out.println(i);
        i = solution673.greedy(new int[]{2, 2, 2, 2, 2});
        System.out.println(i);
        i = solution673.greedy(new int[]{1, 3, 5, 7, 9});
        System.out.println(i);

    }
}
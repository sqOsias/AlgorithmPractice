package DP;

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length<=1){
            return 1;
        }

        int []dp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
        }
        int result=0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            result=Math.max(result,dp[i]);
        }
        return result;

    }

    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        int i = solution300.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);

        i = solution300.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        System.out.println(i);
        i = solution300.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7});
        System.out.println(i);

        i = solution300.lengthOfLIS(new int[]{0});
        System.out.println(i);
    }
}
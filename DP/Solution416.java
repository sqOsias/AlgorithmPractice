package DP;

class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int target=sum/2;
        int[]dp=new int[target+1];
        for (int i = 0; i < nums.length; i++){
            for (int j=target;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;
    }
    public static void main(String[] args) {
        Solution416 s=new Solution416();
        int[] nums={1,5,11,5};
        System.out.println(s.canPartition(nums));
    }
}
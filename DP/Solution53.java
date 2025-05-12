package DP;

class Solution53 {
    public int maxSubArray(int[] nums) {
        int res=Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                res=Math.max(res,sum);

            }
        }
        return res;
    }
    public int maxSubArray1(int[] nums) {
        int res=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {

            sum+=nums[i];
            if (sum>res){
                res=sum;
            }
            sum=Math.max(sum,0);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int res=Integer.MIN_VALUE;
        int[]dp=new int[nums.length];
        dp[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int i = solution53.maxSubArray1(new int[]{-2,-1,-3,-4,-1,-2,-1,-5,-4});
        System.out.println(i);
    }
}
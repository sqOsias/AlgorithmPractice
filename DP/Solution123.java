package DP;

class Solution123 {
    public int maxProfit(int[] prices) {

        int dp[][]=new int [prices.length][5];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        dp[0][3]=-prices[0];
        dp[0][4]=0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=dp[i-1][0];
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        return dp[prices.length-1][4];
    }
    public static void main(String[] args) {
        int prices[]={3,3,5,0,0,3,1,4};
        Solution123 s=new Solution123();
        System.out.println(s.maxProfit(prices));
    }
}
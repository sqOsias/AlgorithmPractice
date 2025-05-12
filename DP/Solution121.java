package DP;

class Solution121 {
    public int maxProfit(int[] prices) {
        int res=0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                res=Math.max(res,prices[j]-prices[i]);
            }
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res=0;
        for (int i = 0; i < prices.length; i++) {
            min= Math.min(min, prices[i]);
            res=Math.max(res,prices[i]-min);
        }
        return res;
    }

    public int maxProfit3(int[] prices) {
        int dp[][]=new int [prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 0; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = solution121.maxProfit(prices);
        System.out.println(i);
    }
}
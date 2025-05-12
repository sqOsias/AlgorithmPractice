package DP;

class Solution122 {
    public int maxProfit(int[] prices) {
        int res=0;
        for (int i = 0; i < prices.length; i++) {
            res+=Math.max(prices[i+1]-prices[i],0);
        }
        return res;
    }
}
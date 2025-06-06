package DP;

class Solution343 {
    public int integerBreak(int n) {
        int []dp=new int[n];
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i / 2; j++) {
                dp[i]=Math.max(dp[i],Math.max((j*(i-j)),j*dp[i-j]));
            }

        }
        return dp[n];
    }
}
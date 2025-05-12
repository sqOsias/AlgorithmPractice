package DP;

class Solution37 {
    public int combinationSum4(int m,int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m; j++) {
                dp[i]+=dp[i-j];

            }
        }
        return dp[n];

     
    }
}
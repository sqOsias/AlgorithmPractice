package DP;

class Solution518 {
    public int change(int amount, int[] coins) {

        int[][]dp=new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0]=1;
        }
        for (int i=coins[0];i<=amount;i++){
            if (i % coins[0] == 0) dp[0][i] = 1;
        }


        for (int i = 1; i < coins.length; i++) {
            for (int j=1;j<=amount;j++){
                if(j<coins[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]];
                }
            }
        }
        return dp[coins.length-1][amount];

    }

    public static void main(String[] args) {
        Solution518 s=new Solution518();
        int[] coins={1,2,5};
        int amount=5;
        System.out.println(s.change(amount, coins));
    }
}
package DP;

import java.util.Scanner;

class Solution1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];


    }
}

//class Main98{
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int M=scanner.nextInt();
//        int N=scanner.nextInt();
//        int []costs=new int [M];
//        int []values=new int [N];
//
//        for (int i = 0; i < M; i++) {
//            costs[i]=scanner.nextInt();
//        }
//        for (int i = 0; i < M; i++) {
//            values[i]=scanner.nextInt();
//        }
//        int []dp=new int[N+1];
//        for (int i = 0; i < M; i++) {
//            for (int j = N; j >=costs[i] ; j--) {
//                dp[j]=Math.max(dp[j],dp[j-costs[i]]+values[i]);
//
//            }
//        }
//        System.out.println(dp[N]);
//        scanner.close();
//
//    }
//}
package bishi.huawei0917;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
    // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
    // please finish the function body here.
    // please define the JAVA output here. For example: System.out.println(s.nextInt());

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(maxScore(nums, k));

    }

    /**
     * 给定一个整数数组和一个整数，返回能够获得的最大得分
     * 每一步最多前进k步，目标是到达数组的最后一个位置
     * 数组是有正有负的
     */
    public static int maxScore(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, preSum[n] - preSum[i - 1] + preSum[Math.min(n, i + k)] - preSum[i]);
            res = Math.max(res, preSum[i - 1] - preSum[0] + preSum[Math.min(n, i + k)] - preSum[Math.max(0, i - k - 1)]);
        }
        return res;

    }
}



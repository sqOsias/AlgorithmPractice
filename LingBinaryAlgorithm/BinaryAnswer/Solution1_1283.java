package LingBinaryAlgorithm.BinaryAnswer;

/**
 * 二分法-求最小
 *
 *
 * 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
 * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
 * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
 * 题目保证一定有解。
 */
class Solution1_1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 0;
        int right = 0;
        for (int x : nums) {
            right = Math.max(right, x);
        }
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, mid, threshold)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int m, int threshold) {
        int sum = 0;
        for (int x : nums) {
            sum += (x + m - 1) / m;  // 向上取整
            if (sum > threshold) { // 提前退出循环
                return false;
            }
        }
        return true;
    }

}
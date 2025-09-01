package LingThreeDoublePointersTwo;

/**
 * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 * 一个子数组指的是原数组中连续的一个子序列。
 * 请你返回满足题目要求的最短子数组的长度。
 * 输入：arr = [1,2,3,10,4,2,3,5]
 * 输出：3
 * 解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
 * 另一个正确的解为删除子数组 [3,10,4] 。
 */
class Solution2_1574 {
    //确定最右边界
    //枚举 left，增大 right 直到 arr[left]≤arr[right]
    //双指针 left指向左子序列的右边界 right指向右子序列的左边界
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) right--;
        if (right == 0) return 0;
        int res = right;

        //now arr[right-1]>arr[right]
        for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; left++) {
            while (right < n && arr[right] < arr[left]) {
                right++;
            }
            //now arr[right]>=arr[left]
            res = Math.min(res, right - left - 1);
        }
        return res;
    }
}
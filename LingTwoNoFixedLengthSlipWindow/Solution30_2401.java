package LingTwoNoFixedLengthSlipWindow;

/**
 * 给你一个由 正 整数组成的数组 nums 。
 *
 * 如果 nums 的子数组中位于 不同 位置的每对元素按位 与（AND）运算的结果等于 0 ，则称该子数组为 优雅 子数组。
 *
 * 返回 最长 的优雅子数组的长度。
 *
 * 子数组 是数组中的一个 连续 部分。
 *
 * 注意：长度为 1 的子数组始终视作优雅子数组。
 */
class Solution30_2401 {
    public int longestNiceSubarray(int[] nums) {
        int res = 0;

        int or =0;

        for (int left =0,right=0;right <nums.length;right++ ){
            while((or & nums[right])>0){
                or ^= nums[left];
                left++;
            }
            or |= nums[right];
            res = Math.max(res,right-left+1);
        }
        return res;


    }
}
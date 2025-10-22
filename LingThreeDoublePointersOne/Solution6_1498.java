package LingThreeDoublePointersOne;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
 *
 * 由于答案可能很大，请将结果对 109 + 7 取余后返回。
 */
class Solution6_1498 {
    private static final int MOD = 1_000_000_007;
    private static final int[] pow2 = new int[100_000]; // 2^i
    private static boolean initialized = false;

    // 这样写比 static block 快
    private void init() {
        if (initialized) {
            return;
        }
        initialized = true;

        pow2[0] = 1;
        for (int i = 1; i < pow2.length; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }
    }
    public int numSubseq(int[] nums, int target) {
        long res=0;
        init();
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
            while(i<=j){
                if (nums[i]+nums[j]<=target){
                    res+=pow2[j-i];
                    i++;
                }else {
                    j--;
                }
            }
            return (int)(res % MOD);
    }

    public static void main(String[] args) {
        Solution6_1498 solution61498 = new Solution6_1498();
        System.out.println(solution61498.numSubseq(new int[]{3,5,6,7},9));
    }
}
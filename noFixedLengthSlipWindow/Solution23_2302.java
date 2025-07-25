package noFixedLengthSlipWindow;

/**
 * 一个数组的 分数 定义为数组之和 乘以 数组的长度。
 *
 * 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
 * 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
 *
 * 子数组 是数组中的一个连续元素序列。
 */
class Solution23_2302 {
    public long countSubarrays(int[] nums, long k) {
        long res =0;
        long ans = 0;
        for (int left = 0, right =0 ;right<nums.length;right++){
            ans+=nums[right];
            while(left<=right && ans*(right-left+1)>=k){
                ans-=nums[left];
                left++;
            }
            res+=right-left+1;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,4,3,5};
        long k = 10;
        Solution23_2302 s = new Solution23_2302();
        System.out.println(s.countSubarrays(nums,k));
    }
}
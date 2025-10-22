package LingTwoNoFixedLengthSlipWindow;
//给你一个整数数组 nums 和一个整数 k 。
//
//一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
//
//如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
//
//请你返回 nums 中 最长好 子数组的长度。
//
//子数组 指的是一个数组中一段连续非空的元素序列。
class Solution7_2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int res= 0;
        int left = 0;
        int[]cnt = new int [100000];  //这里力扣给的测试数据会超出范围，扩大空间则会超内存，需要转换成哈希 表
        for(int right = 0;right<nums.length;right++){
            cnt[nums[right]]++;
            while (cnt[nums[right]]>k){
                cnt[nums[left]] --;
                left++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution7_2958 s = new Solution7_2958();
        int[] nums = {1,2,3,1,2,3,1,2};
        int k = 2;
        System.out.println(s.maxSubarrayLength(nums,k));
    }
}
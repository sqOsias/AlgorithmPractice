package LingTwoNoFixedLengthSlipWindow;
//给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
//
//返回 只删除一个 子数组可获得的 最大得分 。
//
//如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
class Solution6_1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0 ;
        int left = 0;
        int sum = 0;
        int[]cnt = new int[10001];
        for (int right = 0;right<nums.length;right++){
            cnt[nums[right]]++;
            sum += nums[right];
            while(cnt[nums[right]]>1){
                cnt[nums[left]]--;
                sum -= nums[left];
                left++;
            }
            res = Math.max(res,sum);

        }
        return res;
    }
    public static void main(String[] args) {
        int[]nums = {4,2,4,5,6};
        System.out.println(new Solution6_1695().maximumUniqueSubarray(nums));
    }
}
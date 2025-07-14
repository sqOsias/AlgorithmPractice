package noFixedLengthSlipWindow;


//给你一个二进制数组 nums ，你需要从中删掉一个元素。
//
//请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
//
//如果不存在这样的子数组，请返回 0 。


class Solution3_1493 {
    public int longestSubarray(int[] nums) {
        int sum=0;
        for (int num : nums) {
            if (num == 1) {
                sum++;
            }
        }
        if (sum==nums.length){
            return nums.length-1;
        }

        int ans = 0;
        int cnt0=0;
        int left = 0;
        for (int right = 0; right < nums.length; right++){
            cnt0+=1-nums[right];
            while (cnt0>1){
                cnt0-=1-nums[left];
                left++;
            }
            ans=Math.max(ans,right-left);
        }
        return ans;

    }
}
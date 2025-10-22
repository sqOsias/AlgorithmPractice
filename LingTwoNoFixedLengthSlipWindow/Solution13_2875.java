package LingTwoNoFixedLengthSlipWindow;

class Solution13_2875 {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        int l = Math.toIntExact((int) target / total);
        target = (int) ((long) target % total);


        int res = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < n*2; right++) {
            target -= nums[right%n];
            while (target < 0) {
                target += nums[left%n];
                left++;
            }
            if (target == 0) {
                res = Math.min(res, right - left + 1);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res + l * n;
    }

    public static void main(String[] args) {
        Solution13_2875 s = new Solution13_2875();
        int[] nums = {1, 2, 2, 2, 1, 2, 1, 2, 1, 2, 1};
        int target = 83;
        System.out.println(s.minSizeSubarray(nums, target));
    }
}
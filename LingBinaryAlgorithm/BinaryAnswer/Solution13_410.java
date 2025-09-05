package LingBinaryAlgorithm.BinaryAnswer;

/*
  最小化最大值
  二分
 */


/**
 * 给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组，使得这 k 个子数组各自和的最大值 最小。
 * 返回分割后最小的和的最大值。
 * 子数组 是数组中连续的部份。
 */


class Solution13_410 {
    public int splitArray(int[] nums, int k) {
        int mx = 0;
        int sum=0;
        for (int x : nums){
            mx = Math.max(mx,x);
            sum += x;
        }

        int left = mx;
        int right = sum;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if (check(nums,mid,k)){
                right = mid;
            }else{
                left = mid;
            }
        }
        return right;

    }

    private boolean check(int[] nums, int mid, int k) {
        int sum = 0;
        int count = 0;
        for (int x : nums) {
            sum += x;
            if (sum > mid) {
                count++;
                sum = x;
            }
        }
        return count < k;

    }

    public static void main(String[] args) {
        Solution13_410 s = new Solution13_410();
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(s.splitArray(nums, k));
    }


}
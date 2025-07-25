package noFixedLengthSlipWindow;

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 *
 * 子数组 是数组的一段连续部分。
 */
class Solution26_930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt1=0;
        int cnt2=0;
        int sum =0;
        for(int left =0,right =0;right<nums.length;right ++){
            sum += nums[right];
            while(left<=right&& sum>=goal){
                sum-=nums[left];
                left++;
            }
            cnt1+=left;
        }
        sum=0;
        for(int left =0,right =0;right<nums.length;right ++){
            sum += nums[right];
            while(left<=right&&sum>=goal+1){
                sum-=nums[left];
                left++;
            }
            cnt2+=left;
        }
        return cnt1-cnt2;
    }
    public int numSubarraysWithSum1(int[] nums, int goal) {
        int cnt1=0;
        int cnt2=0;
        int sum1 =0;
        int sum2 =0;
        for(int left1 =0,left2=0, right =0;right<nums.length;right ++){
            sum1 += nums[right];
            sum2 += nums[right];
            while(left1<=right&& sum1>=goal){
                sum1-=nums[left1];
                left1++;
            }
            while(left2<=right&&sum2>=goal+1){
                sum2-=nums[left2];
                left2++;
            }
            cnt1+=left1;
            cnt2+=left2;
        }

        return cnt1-cnt2;
    }

    public static void main(String[] args) {
        Solution26_930 s = new Solution26_930();
        int[] nums = {0,0,0,0,0};
        int goal = 0;
        System.out.println(s.numSubarraysWithSum1(nums, goal));
    }
}
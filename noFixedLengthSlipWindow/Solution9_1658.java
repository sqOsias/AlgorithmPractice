package noFixedLengthSlipWindow;

class Solution9_1658 {
    public  int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum==x){
            return nums.length;
        }
        int target = sum - x;
        int left=0;
        int cnt = 0;
        for (int right = 0; right < nums.length; right++){
            target-=nums[right];
            while (target<0&&left<=right){
                target+=nums[left];
                left++;
            }
            if (target==0){
                cnt = Math.max(cnt,right-left+1);
            }
        }
        return cnt == 0 ? -1 : nums.length-cnt;
    }

    public static void main(String[] args) {
        int[] nums = {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
        int x = 134368;
        Solution9_1658 solution91658 = new Solution9_1658();
        System.out.println(solution91658.minOperations(nums,x));
    }
}
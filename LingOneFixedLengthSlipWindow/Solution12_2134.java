package LingOneFixedLengthSlipWindow;

class Solution12_2134 {
    public int minSwaps(int[] nums) {
        int sum = 0 ;
        int n = nums.length;
        int count = 0;
        int min= Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 1) {
                sum++;
            }
        }
        if (sum == 0) return 0;
        for (int i = 0; i < n+sum-1; i++){
            if (nums[i%n]==0){
                count++;
            }
            if (i<sum-1)continue;
            min = Math.min(min,count);
            if (nums[(i-sum+1)%n]==0){
                count--;
            }
        }
        return min;
    }
}
package fixedLengthSlipWindow;

//子数组最大平均数
class Solution1_643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        int res = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            //进入窗口
            sum+=nums[i];
            if (i<k-1){
                continue;
            }
            //更新结果
            res = Math.max(res,sum);
            //离开窗口
            sum-=nums[i-k+1];
        }
        return (double)res/k;
    }
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        Solution1_643 s = new Solution1_643();
        double res = s.findMaxAverage(nums,k);
        System.out.println(res);
    }
}
package fixedLengthSlipWindow;

import java.util.Arrays;

// 2090. 找出数组中的第 k 个最大元素
class Solution4_2090 {
    public int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];

        long[] preSum = new long[nums.length+1];
        preSum[0] = 0;
        for (int i= 1;i<=nums.length;i++){
            preSum[i] = preSum[i-1]+nums[i-1];
        }
        for (int i = 0; i < nums.length; i++){
            if(i-k<0||i+k>nums.length-1){
                res[i]=-1;
            }else {
                res[i] = (int)((preSum[i+k+1]-preSum[i-k])/((2*k+1)));
            }
        }
        return res;
    }

    public int[] getAverages1(int[] nums, int k) {
        int[] res = new int[nums.length];
        long sum = 0;
        Arrays.fill(res,-1);
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (i<2*k)  {
                continue;
            }else {
                res[i-k] = (int)(sum/(2*k+1));
                sum -= nums[i-2*k];
            }

        }
        return res;

    }



    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        int k = 3;
        Solution4_2090 s = new Solution4_2090();
        int[] res = s.getAverages(nums, k);
        for (int i = 0; i < res.length; i++){
            System.out.print(res[i]+" ");
        }
    }
}
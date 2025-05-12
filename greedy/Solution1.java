package greedy;

public class Solution1 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum =0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            result=sum>result?sum:result;
            sum=sum<0?0:sum;
        }
        return result;
    }
}
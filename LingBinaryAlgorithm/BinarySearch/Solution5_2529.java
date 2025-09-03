package LingBinaryAlgorithm.BinarySearch;

/**
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 */
class Solution5_2529 {
    public int maximumCount(int[] nums) {
        int neg= lowerBound(nums,-1);
        int i = lowerBound(nums, 0);
        int pos = nums.length-i;
        return Math.max(neg,pos);
    }

    int lowerBound(int []nums,int target){
        int left =-1,right = nums.length;
        while(left+1<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid;
            }else{
                left=mid;
            }
        }
        return right;
    }

}
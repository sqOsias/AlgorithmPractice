package LingBinaryAlgorithm.BinarySearch;


/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
 * 你必须编写一个具有 O(log n) 时间复杂度的算法。
 */
class Solution3_704 {
    public int search(int[] nums, int target) {
        int i = lowerBound(nums, target);
        return i < nums.length && nums[i] == target ? i : -1;
    }

    // lowerBound 返回最小的满足 nums[i] >= target 的下标 i
    // 如果数组为空，或者所有数都 < target，则返回 nums.length
    // 如果所有数都大于 target，则返回 0
    // 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]

    private int lowerBound(int[] nums,int target){
        int left=-1,right=nums.length;
        while(left+1<right){
            int mid = left + (right-left)/2;
            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid;
            }

        }
        //right 就是第一个 >= target 的元素下标
        return right;
    }
}
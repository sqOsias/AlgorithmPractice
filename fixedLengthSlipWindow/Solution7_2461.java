package fixedLengthSlipWindow;


import java.util.HashMap;

//给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
//
//子数组的长度是 k，且
//子数组中的所有元素 各不相同 。
//返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
//
//子数组 是数组中一段连续非空的元素序列。
class Solution7_2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        long sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            if(i<k-1){
                continue;
            }
            if (map.size() == k){
                res=Math.max(res, sum);
            }
            sum -= nums[i-k+1];
            map.put(nums[i-k+1], map.get(nums[i-k+1])-1);
            if (map.get(nums[i-k+1])<1){
                map.remove(nums[i-k+1]);
            }
        }
        return res;
    }

    public boolean checkMap(HashMap<Integer,Integer> map){
        for(Integer key:map.keySet()){
            if(map.get(key)>1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,7,8,9};
        int k = 3;
        System.out.println(new Solution7_2461().maximumSubarraySum(nums, k));
    }
}
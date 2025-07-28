package LingTwoNoFixedLengthSlipWindow;

import java.util.HashMap;

/**
 * 给定一个正整数数组 nums和一个整数 k，返回 nums 中 「好子数组」 的数目。
 *
 * 如果 nums 的某个子数组中不同整数的个数恰好为 k，则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。
 *
 * 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
 * 子数组 是数组的 连续 部分。
 */
class Solution29_992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return f1(nums,k)-f1(nums,k-1);
    }

    public static int f(int[]nums,int k ){
        int res=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int left = 0, right =0 ;right<nums.length;right++){
            map.merge(nums[right],1,Integer::sum);
            while( map.size()>k){
                map.merge(nums[left],-1,Integer::sum);
                if (map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            res += right - left+1 ;
        }
        return res;
    }

    public static int f1(int[]nums,int k ){
        int res=0;
        int[]cnt = new int[nums.length+1];
        int cnt1 = 0;
        for (int left = 0, right =0 ;right<nums.length;right++){
            if (cnt[nums[right]]==0){
                cnt1++;
            }
            cnt[nums[right]]++;
            while(cnt1>k){
                int out = nums[left];
                if (cnt[out]==1){
                    cnt1--;
                }
                cnt[out]--;
                left++;
            }
            res += right - left+1 ;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 1;
        Solution29_992 solution29992 = new Solution29_992();
        System.out.println(solution29992.subarraysWithKDistinct(nums, k));

    }
}
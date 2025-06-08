package backtracking.seconde;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 */
class Solution78 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return res;
    }
    public void backtracking(int[] nums,int startIndex){
        res.add(new ArrayList<>(path));
        if (startIndex>=nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.remove(path.size()-1);
        }

    }
}
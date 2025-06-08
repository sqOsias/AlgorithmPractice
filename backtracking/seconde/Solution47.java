package backtracking.seconde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution47 {
    List<List<Integer>> res= new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums,0,new boolean[nums.length]);
        return res;
    }

    public void backtracking(int[] nums,int index,boolean[]flag){
        if(index==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (i>0&&nums[i]==nums[i-1]&&!flag[i-1]) continue;
            if (!flag[i]){
                flag[i]=true;
                path.add(nums[i]);
                backtracking(nums,index+1,flag);
                path.remove(path.size()-1);
                flag[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        int[] nums = {1,1,2};
        List<List<Integer>> lists = solution47.permuteUnique(nums);
        System.out.println(lists);
    }
}
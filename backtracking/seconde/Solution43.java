package backtracking.seconde;

import java.util.ArrayList;
import java.util.List;

class Solution43 {
    List<List<Integer>> res= new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums,0,new boolean[nums.length]);
        return res;
        
    }
    public void backtracking(int[] nums,int index,boolean[]flag){
        if(index==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<nums.length;i++){
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
        Solution43 s = new Solution43();
        int[] nums = {1,2,3};
        System.out.println(s.permute(nums));
    }
}
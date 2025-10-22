package backtracking.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution90 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums,0);
        return res;
    }

    public void backtracking(int[] nums,int startIndex){
        if (!res.contains(path)){
            res.add(new ArrayList<>(path));
        }

        for (int i=startIndex;i<nums.length;i++){
            if(i>startIndex&&nums[i]==nums[i-1]){
                continue;
            }
            if (path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] nums={1,2,2};
        Solution90 solution90=new Solution90();
        List<List<Integer>> res=solution90.subsetsWithDup(nums);
        for (List<Integer> list:res){
            for (int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
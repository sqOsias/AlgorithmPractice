package backtracking.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution491 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {

        backtracking(nums,0);
        return res;
    }

    private void backtracking(int[] nums, int index) {
        if (path.size() > 1){
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> hs=new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!path.isEmpty()&&nums[i]>=path.get(path.size()-1 )|| hs.contains(nums[i]))continue;

            hs.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.remove(path.size()-1);
        }

    }
    private boolean isValid(List<Integer> path) {
        for (int i = 0; i < path.size()-1; i++) {
            if (path.get(i) > path.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        Solution491 solution491 = new Solution491();
        List<List<Integer>> subsequences = solution491.findSubsequences(nums);
        for (List<Integer> list:subsequences){
            for (int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
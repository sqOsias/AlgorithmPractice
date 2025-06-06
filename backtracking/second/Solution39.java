package backtracking.second;

import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer>path  =new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates==null||candidates.length==0){
            return res;
        }
        backtracking(0,target,candidates);
        return res;
    }

    public void backtracking(int start,int rest,int[] candidates){
        if (rest==0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (rest<0){
            return;
        }
        for (int i=start;i<candidates.length;i++){
            path.add(candidates[i]);
            backtracking(i,rest-candidates[i],candidates);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        Solution39 solution39 = new Solution39();
        List<List<Integer>> res = solution39.combinationSum(candidates, target);
        System.out.println(res);
    }
}

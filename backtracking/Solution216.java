package backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution216 {
    List<List<Integer>>res=new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int sum=n;
        backtracking(k,1,sum);
        return res;
    }

    public void backtracking(int k,int index,int sum){
        if (sum==0){
            if (path.size()==k){
                res.add(new ArrayList<>(path));
                return;
            }
        }
        if (path.size()==k&&sum!=0){
            return;
        }

        for (int i=index;i<=9;i++){
            if(sum<i){
                continue;
            }
            path.add(i);
            backtracking(k,i+1,sum-i);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution216 solution216=new Solution216();
        List<List<Integer>> lists = solution216.combinationSum3(3, 9);
        System.out.println(lists);
    }
}
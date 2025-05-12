package backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
    backtracking(n,k,1);
    return result;
    }
    public void backtracking(int n,int k ,int startIndex){
        if(path.size()==k){
            if(path.stream().reduce(0,(a,b)->a+b)==n){
                result.add(new ArrayList<>(path));
            }

        }
        for(int i=startIndex;i<=n;i++){
            path.add(i);
            backtracking(n,k,i+1);
            path.remove(path.size()-1);
        }
    }

}
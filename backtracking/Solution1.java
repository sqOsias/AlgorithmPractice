package backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    List<List<Integer>>result = new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }
    public void backtracking(int n,int k,int startIndex){
        if(path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<(n-(k-path.size())+1);i++){
            path.add(i);
            backtracking(n,k,i+1);
            path.remove(path.size()-1);
        }
    }
}
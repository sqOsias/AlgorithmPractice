package backtracking.seconde;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        backtrack(n,k,1);
        return res;

    }

    public void backtrack(int n,int k,int start){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<=n-(k-path.size())+1;i++){
            path.add(i);
            backtrack(n,k,i+1);
            path.remove(path.size()-1);
        }


    }

    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        List<List<Integer>> combine = solution77.combine(4, 2);
        System.out.println(combine);
    }
}

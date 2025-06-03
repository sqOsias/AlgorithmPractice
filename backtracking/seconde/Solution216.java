package backtracking.seconde;

import java.util.ArrayList;
import java.util.List;
//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
//
//只使用数字1到9
//每个数字 最多使用一次
//返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
class Solution216 {
    List<List<Integer>>res=new ArrayList<>();
    List<Integer>path=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1);
        return res;

    }
    public void backtracking(int k,int ln,int startIndex){
        if (ln==0){
            if(path.size()==k){
                res.add(new ArrayList<>(path));
            }
        }
        for(int i=startIndex;i<=9;i++){
            path.add(i);
            backtracking(k,ln-i,i+1);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        Solution216 s=new Solution216();
        System.out.println(s.combinationSum3(3,7));
    }
}
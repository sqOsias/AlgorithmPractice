package backtracking.seconde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution44 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            target -= candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, i + 1);
            target += candidates[i];
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution44 s = new Solution44();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(s.combinationSum2(candidates, target));
    }
}
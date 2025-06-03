package backtracking.seconde;

import java.util.ArrayList;
import java.util.List;

class Solution131 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    void backtracking(String s, int start) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalidrome(s, start, i)) {
                String str = s.substring(start, i + 1);
                path.add(str);
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    boolean isPalidrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution131 s = new Solution131();
        String str = "aab";
        List<List<String>> res = s.partition(str);
        System.out.println(res);
    }
}
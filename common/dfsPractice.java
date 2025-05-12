package common;

import java.util.*;

public class dfsPractice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        // 输入校验
        if (n < 0) {
            System.out.println("Invalid input: n must be non-negative.");
            return;
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, n, new boolean[n], path, res);

        System.out.println(res);
    }


    public static void dfs(int start, int n, boolean[] marked, List<Integer> path, List<List<Integer>> res) {
        if (start >= n) {
            // 添加路径的副本，避免引用问题
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                marked[i] = true;
                path.add(i); // 选择当前节点
                dfs(start + 1, n, marked, path, res); // 递归
                path.remove(path.size() - 1); // 回溯
                marked[i] = false; // 撤销选择
            }
        }
    }


}



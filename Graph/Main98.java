package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main98 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void dfs(int[][] graph, int index, int n) {
        if (index == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (graph[index][i] == 1) {
                path.add(i);
                dfs(graph, i, n);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void dfs1(List<LinkedList<Integer>>graph, int index, int n) {
        if (index == n){
            result.add(new ArrayList<>(path));
            return;
        }
        for  (int i:graph.get(index)){
            path.add(i);
            dfs1(graph, i, n);
            path.remove(path.size() - 1);
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            graph[s][t] = 1;
        }

        path.add(1);
        dfs(graph, 1, n);
        if (result.isEmpty()) {
            System.out.println("-1");
        }
        for (List<Integer> pa : result) {
            for (int i = 0; i < pa.size() - 1; i++) {
                System.out.print(pa.get(i) + " ");
            }
            System.out.println(pa.get(pa.size() - 1));
        }
    }
}

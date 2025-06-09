package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Solution994 {
    public int orangesRotting(int[][] grid) {

        int M = grid.length;
        int N = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int count = 0; //记录新鲜橘子的数量
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int time = 0;
        while (!queue.isEmpty() && count > 0) {
            time++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    queue.offer(new int[]{r - 1, c});
                    count--;
                }

                if (r + 1 < M && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    queue.offer(new int[]{r + 1, c});
                    count--;
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1){
                    grid[r][c - 1] = 2;
                    queue.offer(new int[]{r, c - 1});
                    count--;
                }
                if(c + 1 < N && grid[r][c + 1] == 1){
                    grid[r][c + 1] = 2;
                    queue.offer(new int[]{r, c + 1});
                    count--;
                }
            }
        }
        return count == 0 ? time : -1;

    }



}
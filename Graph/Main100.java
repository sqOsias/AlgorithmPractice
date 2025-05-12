package Graph;

import java.util.Scanner;

public class Main100 {
    public static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public static int count;
    public static void dfs(int[][]graph,boolean[][]visited,int x,int y){

        for (int i = 0; i < 4; i++) {
            int nextX=x+dir[i][0];
            int nextY=y+dir[i][1];
            if (nextY<0||nextX<0||nextX>=graph.length||nextY>=graph[0].length) {
                continue;
            }
            if(!visited[nextX][nextY]&&graph[nextX][nextY]==1){
                count++;
                visited[nextX][nextY]=true;
                dfs(graph,visited,nextX,nextY);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int graph[][]=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                graph[i][j]=scanner.nextInt();
        }

        boolean[][] visited = new boolean[m][n];
        int ans=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]&&graph[i][j]==1){
                    count=1;
                    visited[i][j]=true;
                    dfs(graph,visited,i,j);//将与其链接的陆地都标记上 true
                    ans=Math.max(ans,count);
                }
            }
        }
        System.out.println(ans);
    }
}

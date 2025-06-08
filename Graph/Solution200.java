package Graph;

class Solution200 {
    //0 海洋 1  岛屿 2  已访问
    public int numIslands(char[][] grid) {
        int res=0;
        for (int r=0;r<grid.length;r++){
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c]=='1'){
                    res++;
                    dfs(grid,r,c);
                }

            }
        }
        return res;
    }
    int area(char [][] grid,int r,int c){
        if(!inArea(grid,r,c)){
            return 0;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c]!='1') {
            return 0;
        }
        grid[r][c] = '2'; // 将格子标记为「已遍历过」
        return 1+area(grid,r-1,c)
                +area(grid,r+1,c)
                +area(grid,r,c-1)
                +area(grid,r,c+1);
    }


    void dfs(char [][] grid,int r,int c){
        if(!inArea(grid,r,c)){
            return ;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c]!='1') {
            return;
        }
        grid[r][c] = '2'; // 将格子标记为「已遍历过」
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    boolean inArea(char[][] grid,int r,int c){
        return 0<=r &&r<grid.length
                &&0<=c &&c<grid[0].length;
    }

    public static void main(String[] args) {
        char [][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(new Solution200().numIslands(grid));
    }
}
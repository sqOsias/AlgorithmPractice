package Graph;

class Solution463 {

    //0 海洋 1  岛屿 2  已访问

    public int islandPerimeter(int[][] grid) {
        for (int r=0;r<grid.length;r++){
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    int dfs(int [][] grid, int r,int c ){
        if(!inArea(grid,r,c)){
            return 1;
        }
        if (grid[r][c] == 0){
            return 1;
        }
        if (grid[r][c] != 1){
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid,r-1,c) + dfs(grid,r+1,c) + dfs(grid,r,c-1) + dfs(grid,r,c+1);
    }

    boolean inArea(int [][] grid, int r, int c){
        return 0<=r && r<grid.length && 0<=c && c<grid[0].length;

    }
}
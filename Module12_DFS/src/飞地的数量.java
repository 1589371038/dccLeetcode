/**
 * 1020. 飞地的数量
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 *
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 *
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 * 思路：从每个边界访问dfs，最后剩下的1的数量就是答案
 */

public class 飞地的数量 {
    public int numEnclaves(int[][] grid) {
        for (int j = 0; j< grid[0].length; j++){
            if(grid[0][j]==1){
                dfs(grid,0,j);
            }
            if(grid[grid.length-1][j]==1){
                dfs(grid,grid.length-1,j);
            }
        }
        for (int i = 0; i< grid.length; i++){
            if(grid[i][0]==1){
                dfs(grid,i,0);
            }
            if(grid[i][grid[0].length-1]==1){
                dfs(grid,i,grid[0].length-1);
            }
        }
        int count =0;
        for(int i=0;i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if (grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 ||j>=grid[0].length || grid[i][j] ==0){
            return;
        }
        grid[i][j]=0;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }


}

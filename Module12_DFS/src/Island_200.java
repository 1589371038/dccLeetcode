//200. 岛屿数量
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
//
//此外，你可以假设该网格的四条边均被水包围。
//深度优先搜索
public class Island_200 {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int sum=0;//计数
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1') { //如果碰到岛屿，开始深度优先搜索抹除1
                    dfs(grid, i, j);
                    sum++; //遇到一次1，岛屿增加1个
                }
            }
        }
        return sum;

    }

    private void dfs(char[][] grid, int i, int j) {
        int m=grid.length; //长
        int n=grid[0].length; //宽
        if(i<0||i>=m||j<0||j>=n||grid[i][j]=='0'){  //搜索到非岛屿就停止
            return;
        }
        //经过排除后，ij处的点为1，可以置0；
        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}

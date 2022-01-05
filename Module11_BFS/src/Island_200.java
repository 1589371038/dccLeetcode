import java.util.LinkedList;
import java.util.Queue;

////200. 岛屿数量
////给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
////
////岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
////
////此外，你可以假设该网格的四条边均被水包围。
////广度优先搜索  队列迭代
public class Island_200 {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        Queue<Integer> queue=new LinkedList<>();
        int num=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    num++;
                    grid[i][j]='0';
                 int id=i*n+j;
                 queue.offer(id);
                 while(!queue.isEmpty()){
                     int newId=queue.poll(); //抛出队列头，并把队列头的上下左右，符合条件的加入队列
                     int ii=newId/n;
                     int jj=newId%n; //(ii,jj)的上下左右进行判断
                     if(ii-1>=0&&grid[ii-1][jj]=='1'){ //上边，在矩阵内且为1，则加入队列
                         queue.offer((ii-1)*n+jj);
                         grid[ii-1][jj]='0';
                     }
                     if(ii+1<m&&grid[ii+1][jj]=='1'){ //下边，在矩阵内且为1，则加入队列
                         queue.offer((ii+1)*n+jj);
                         grid[ii+1][jj]='0';
                     }
                     if(jj-1>=0&&grid[ii][jj-1]=='1'){ //左边，在矩阵内且为1，则加入队列
                         queue.offer((ii)*n+jj-1);
                         grid[ii][jj-1]='0';
                     }
                     if(jj+1<n&&grid[ii][jj+1]=='1'){ //右边，在矩阵内且为1，则加入队列
                         queue.offer((ii)*n+jj+1);
                         grid[ii][jj+1]='0';
                     }

                 }
                }
            }
        }
      return num;
    }
}

import java.util.Arrays;
//63. 不同路径 II
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
//现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//网格中的障碍物和空位置分别用 1 和 0 来表示。

public class PathNums2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [] dp=new int[obstacleGrid[0].length]; //一维dp
        for(int j=obstacleGrid[0].length-1;j>=0;j--){ //初始化，如果出现了1，那么左边都是不能行，dp为0 !!!!!!
           if(obstacleGrid[obstacleGrid.length-1][j]==0){
               dp[j]=1;
           }
           else{
               break;
           }
        }
        //初始化，我用的一维，但是竖着的最右边也要考虑如果出现了1，那么上面都是不能行，dp为0 !!!!!!
        //用dpshu表示最右边竖着的一列的状态
        int []dpshu=new int[obstacleGrid.length];
        for(int i=obstacleGrid.length-1;i>=0;i--){
            if(obstacleGrid[i][obstacleGrid[0].length-1]==0){
                dpshu[i]=1;
            }
            else{
                break;
            }
        }
        for(int i=obstacleGrid.length-2;i>=0;i--){
            dp[obstacleGrid[0].length-1]=dpshu[i];
        for(int j=obstacleGrid[0].length-2;j>=0;j--){
               if(obstacleGrid[i][j]==0){
                    dp[j]=dp[j]+dp[j+1];
               }
               else{
                   dp[j]=0;
               }
            }
        }
        return dp[0];
    }
}

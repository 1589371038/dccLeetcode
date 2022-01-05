//64. 最小路径和
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//说明：每次只能向下或者向右移动一步。
//典型的dp，可二维可一维
//dp[ij]=max(dp[i][j+1],dp[i+1][j])+grid[i][j]
public class MinPathSum {
    public int minPathSum(int[][] grid) {
     int [][]dp=new int[grid.length][grid[0].length];
     dp[grid.length-1][grid[0].length-1]=grid[grid.length-1][grid[0].length-1];
     for(int j=grid[0].length-2;j>=0;j--){ //初始化最下面一行
         dp[grid.length-1][j]=grid[grid.length-1][j]+dp[grid.length-1][j+1];
     }
     for(int i=grid.length-2;i>=0;i--){
         dp[i][grid[0].length-1]=grid[i][grid[0].length-1]+dp[i+1][grid[0].length-1];
     }
     for(int j=grid[0].length-2;j>=0;j--){
         for(int i=grid.length-2;i>=0;i--){
             dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
         }
     }
return dp[0][0];
    }

//2021.10.30 重新写一次
    public static int minPathSum1(int[][] grid) {
        if(grid == null || grid.length == 0 ){
            return 0;
        }
        int [][] dp =new int[grid.length][grid[0].length];
        //想要不初始化一起做了，但是还是不行
//        for(int i = 0; i<dp.length; i++){
//            for(int j = 0; j<dp[0].length; j++){
//                //如果是0就不能算，不然会乱
//                dp[i][j] = Math.min(getDp(dp,i-1,j),getDp(dp,i, j-1))+grid[i][j];
//            }
//        }
        dp[0][0] = grid[0][0];
        for(int i=1;i<dp.length;i++){
            dp[i][0] = dp [i-1][0]+grid[i][0]; //初始化第一行
        }
        for(int j=1;j<dp[0].length;j++){
            dp[0][j] = dp [0][j-1]+grid[0][j]; //初始化第一行
        }
                for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
//getDp是为了解决i，j<0时的越界问题
//    private static int getDp(int[][] dp, int i, int j) {
//        if(i<0 || j<0){
//            return 0;
//        }else {
//            return dp[i][j];
//        }
//    }

    public static void main(String[] args) {
        int [][] x = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        minPathSum1(x);
    }
}

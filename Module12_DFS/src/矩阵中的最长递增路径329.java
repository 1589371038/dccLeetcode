
//329. 矩阵中的最长递增路径
//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
//
//对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
//思考：典型的回溯深度优先遍历搜索,如果从每个节点开始搜索找到最大的长度，就能获得结果，但是时间复杂度太高了，一定要有记忆
//优化1 不需要记忆哪里走过了，也不需要回溯，因为是递增序列所以同一次路是递增的，不会走到原路
//优化2 到了某个点开始出发，就可以算出以此点为起点的路径最大值，记录在max[][]数组当中。

//搜索的方式有两种：1传递累计的步数到下一步，在终点计数  2用递归的方式 max= max, 1+ 下一步的max 计算以此点为起点的最大值
//这里用第二种
 public class 矩阵中的最长递增路径329 {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length<1||matrix[0].length<1){
            return 0;
        }
        int maxLen = 0;
        int[][] max = new int[matrix.length][matrix[0].length];//记录以某点为出发的最大长度
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int thisMax= dfs(matrix,max,i,j);
                maxLen = Math.max(maxLen,thisMax);
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int[][] max, int i, int j) {
        if(max[i][j]>0){
            return max[i][j];
        }//如果已经走过了不必再走
        int step=1;
        if(i-1>=0&&matrix[i-1][j]>matrix[i][j]){//如果能走上边
            step=Math.max(step,1+dfs(matrix,max,i-1,j));
        }
        if(i+1<matrix.length&&matrix[i+1][j]>matrix[i][j]){//如果能走下边
            step=Math.max(step,1+dfs(matrix,max,i+1,j));
        }
        if(j-1>=0&&matrix[i][j-1]>matrix[i][j]){//如果能走左边
            step=Math.max(step,1+dfs(matrix,max,i,j-1));
        }
        if(j+1<matrix[0].length&&matrix[i][j+1]>matrix[i][j]){//如果能走右边
            step=Math.max(step,1+dfs(matrix,max,i,j+1));
        }

        max[i][j]=step;
        return step;
    }
}

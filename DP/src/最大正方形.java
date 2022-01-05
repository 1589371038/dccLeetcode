/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * 思路dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
 * 边界为0/1
 */

public class 最大正方形 {
    public static int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length<1){
            return 0;
        }
        int max=0;
    int[][] dp =new int[matrix.length][matrix[0].length];
    for(int i=0;i<matrix.length;i++){
        dp[i][0]=matrix[i][0]=='0'?0:1;
        max = Math.max(max,dp[i][0]);
    }
    for(int j=0;j<matrix[0].length;j++){
        dp[0][j]=matrix[0][j]=='0'?0:1;
        max = Math.max(max,dp[0][j]);
    }
    //初始化完了开始递推
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return (int)Math.pow(max,2);
    }

    public static void main(String[] args) {
        char [][]matrix=new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        maximalSquare(matrix);
    }
}

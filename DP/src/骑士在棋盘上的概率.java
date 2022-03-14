/**
 * 688. 骑士在棋盘上的概率
 * 在一个n x n的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 *
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/knight-probability-in-chessboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * dp[k][i][j] 表示从ij移动k次后还在棋盘上的概率
 * dp[k][i][j] = 求和dp[k-1][i下一步][j下一步]
 * 边界：dp[o][i][j] = 1
 * i和j出界的时候=0；
 */

public class 骑士在棋盘上的概率 {
    public static double knightProbability(int n, int k, int row, int column) {
        double dp[][][] = new double[k+1][n][n];
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                dp[0][i][j] = 1;
            }
        }
        int[][] moves = new int[][] {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
        for (int s = 1; s<=k; s++){
            for (int i = 0; i<n; i++){
                for (int j = 0; j<n; j++){
                    for(int [] move: moves ){
                        if(i+move[0] >= 0 && i+move[0] < n && j+move[1] >= 0 && j+move[1] < n){ // 如果移动后还在棋盘上
                            dp[s][i][j] =  dp[s][i][j] +  dp[s-1][i+move[0]][j+move[1]] / 8 ;
                        }

                    }

                }
            }
        }
        return dp[k][row][column];
    }

    public static void main(String[] args) {
        knightProbability(3,2,0,0);
    }
}

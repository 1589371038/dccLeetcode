/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 *
 * 示例 1：
 *
 * 输入：board = [["X","X","X","X"]
 *              ,["X","O","O","X"],
 *               ["X","X","O","X"],
 *               ["X","O","X","X"]]
 * 输出：[["X","X","X","X"],
 *       ["X","X","X","X"],
 *       ["X","X","X","X"],
 *       ["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 思路：就是统计哪些o能被保住，根据规则，1最外圈的o被保住了，2与最外圈的o相连或者间接相连的o被保住了
 * 那就有点像岛屿数量了，可以bfs或者dfs从每个外圈o出发统计哪些o被保住了(连接)，
 * 用一个boolean[][]来记录
 * 然后遍历一遍，除了boolean[][]保住的，其他全部变成x
 */

public class 被围绕的区域130 {
    public static void solve(char[][] board) {
        boolean[][] keepO = new boolean[board.length][board[0].length];
        for(int j=0;j<board[0].length;j++){  //四个for为一圈
            dfs(board,keepO,0,j);
        }
        for(int i=0;i<board.length;i++){
            dfs(board,keepO,i,board[0].length-1);
        }
        for(int j=board[0].length-1;j>=0;j--){  //四个for为一圈
            dfs(board,keepO,board.length-1,j);
        }
        for(int i=board.length-1;i>=0;i--){
            dfs(board,keepO,i,0);
        }
        //记录好所有被保住的o的位置后，开始工作，所有其他地方变成X
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!keepO[i][j]){
                    board[i][j]='X';
                }

            }
        }
    }

    private static void dfs(char[][] board, boolean[][] keepO, int i, int j) {
        //不走这一步的情况 越界/走过了/不是O
        if(i<0||i>=board.length||j<0||j>=board[0].length||keepO[i][j]||board[i][j]!='O'){
            return;
        }
        keepO[i][j]=true; //表示这个O被保住了，而且以后别再走这个了
        dfs(board,keepO,i-1,j);
        dfs(board,keepO,i+1,j);
        dfs(board,keepO,i,j-1);
        dfs(board,keepO,i,j+1);
    }

    public static void main(String[] args) {
        char [][] nums = new char[][]{{'O'}};
        solve(nums);
    }
}

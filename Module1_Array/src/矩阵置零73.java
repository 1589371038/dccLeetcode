/**
 * moon
 */
//73. 矩阵置零
//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//思路1最简单 用两个flag记录需要清零的行和列，扫描mn，然后再根据flag清零
//题目要求额外空间为常数级，flag就不能用
//用第一行和第一列当flag, 需要置零就变成0，但是这样第一行和第一列是否置0就丢了，用两个数字cow0 cow1来记录是否第一行列需要置零
public class 矩阵置零73 {
    public void setZeroes(int[][] matrix) {
        boolean col0 = false;
        boolean row0 = false;
        //记录第一行是否需要置0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
            }
        }
        //用第一行和第一列记录剩下的行列是否需要置0
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //开始对剩下的行列置0；
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //用第一行第一列的标记判断是否需要置0
        if(row0){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }
        if(col0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }
}

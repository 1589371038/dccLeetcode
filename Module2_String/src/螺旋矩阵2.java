/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */

public class 螺旋矩阵2 {
    public static int[][] generateMatrix(int n) {
        int left=0;
        int right=n-1;
        int top =0;
        int bottom=n-1;
        int[][] result = new int[n][n];
        int num=1;
        while (left<=right&&top<=bottom){
            for(int j=left;j<=right;j++){
                result[top][j]=num++;
            }
            top++;
            if(top>bottom) break;
            for(int i=top;i<=bottom;i++){
                result[i][right]=num++;
            }
            right--;
            if(left>right) break;
            for(int j=right;j>=left;j--){
                result[bottom][j]=num++;
            }
            bottom--;
            if(top>bottom) break;
            for(int i=bottom;i>=top;i--){
                result[i][left]=num++;
            }
            left++;
            if(left>right) break;
        }
        return  result;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
    }
}

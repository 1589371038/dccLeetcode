//48. 旋转图像
//给定一个 n × n 的二维矩阵表示一个图像。
//
//将图像顺时针旋转 90 度。
public class Rotation {
    public void rotate(int[][] matrix) {
        if(matrix==null)
            return;
        int n=matrix.length;
        //先转置
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int tempt=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tempt;
            }
        }
        //再每一行翻转
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int k=n-1-j;
                int tempt=matrix[i][j];
                matrix[i][j]=matrix[i][k];
                matrix[i][k]=tempt;

            }
        }


    }
}

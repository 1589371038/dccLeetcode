import java.util.ArrayList;
import java.util.List;
//顺时针打印，输出最外圈后，给矩阵减肥
public class ShunShiZhenPrint {
    public List<Integer> spiralOrder(int [][] matrix) {

        ArrayList<Integer> array=new ArrayList<>();
        if(matrix==null||matrix.length==0){
            return array;
        }
//一圈输出，然后减肥，直到不可再减
        while(matrix.length>=2&&matrix[0].length>=2){
            for(int j=0;j<matrix[0].length-1;j++){
                array.add(matrix[0][j]);
            }
            for(int i=0;i<matrix.length-1;i++){
                array.add(matrix[i][matrix[0].length-1]);
            }
            for(int j=matrix[0].length-1;j>0;j--){
                array.add(matrix[matrix.length-1][j]);
            }
            for(int i=matrix.length-1;i>0;i--){
                array.add(matrix[i][0]);
            }
            if(matrix.length==2||matrix[0].length==2){
                return array;
            }
            matrix=jianfei(matrix);
        }
        if(matrix.length<=matrix[0].length){
            for(int j=0;j<matrix[0].length;j++)
                array.add(matrix[0][j]);
            return  array;
        }
        else{
            for(int i=0;i<matrix.length;i++)
                array.add(matrix[i][0]);
            return array;
        }

    }
    public int[][] jianfei (int [][] matrix){
        int[][] newmatrix=new int[matrix.length-2][matrix[0].length-2];
        for(int i=1;i<matrix.length-1;i++){
            for(int j=1;j<matrix[0].length-1;j++){
                newmatrix[i-1][j-1]=matrix[i][j];
            }
        }
        return newmatrix;
    }
}

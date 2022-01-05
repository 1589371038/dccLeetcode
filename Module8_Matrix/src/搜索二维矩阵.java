//240. 搜索二维矩阵 II
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
//
//每行的元素从左到右升序排列。
//每列的元素从上到下升序排列。
public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length<1||matrix[0].length<1){
            return  false;
        }
        //先确定搜索范围，再用二分法 rowEnd 和colEnd
        int rowEnd=0;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]>target){
                rowEnd=i;
                break;
            }
        }
        if(matrix[matrix.length-1][0]<=target){
            rowEnd=matrix.length;
        }
        int colEnd=0;
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]>target){
                colEnd=i;
            }
        }
        if(matrix[0][matrix[0].length-1]<=target){
            colEnd=matrix[0].length;
        }
        //如果colend或者rowEnd小于等于0，直接false
        if(colEnd<=0||rowEnd<=0){
            return false;
        }
        //确定了行和列的搜索范围,每行用二分搜索
        for(int i=0;i<rowEnd;i++){
            //如果行尾小于target，不搜了，continue
            if(matrix[i][colEnd-1]<target){
                continue;
            }
           int start=0;
           int end=colEnd-1;
           int mid=(start+end)/2;
           while(start<=end){
               mid=(start+end)/2;
            if(matrix[i][mid]==target){
                return true;
            }
            else if(matrix[i][mid]<target){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
           }

        }
        return false;


    }
}

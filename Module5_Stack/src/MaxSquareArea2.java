public class MaxSquareArea2 {
    public static void main(String[] args) {
        char[][] matrix={{'1','0','0'},{'1','1','1'},{'1','1','1'},{'0','1','0'}};
        int result=maximalSquare(matrix);
        System.out.println(result);
    }
    public static  int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return  0;
        }
        int maxArea=0;
        int [] dp=new int[matrix[0].length];
        for(int j=0;j<matrix[0].length;j++){
            dp[j]=matrix[0][j]=='1'?1:0;
            maxArea=Math.max(dp[j],maxArea);
        }//初始化第一行
for(int i=1;i<matrix.length;i++){
    int prev=dp[0];//上一行的左边
    dp[0]=matrix[i][0]=='1'?1:0;
    maxArea=Math.max(dp[0],maxArea);
    for(int j=1;j<matrix[0].length;j++){
        int temp=dp[j];
        if(matrix[i][j]=='1') {
            dp[j] = Math.min(Math.min(prev, dp[j - 1]), dp[j]) + 1;
            maxArea=Math.max(dp[j],maxArea);
        }
        else{
            dp[j]=0;
        }
        prev=temp;
    }
}
return maxArea*maxArea;
    }
}

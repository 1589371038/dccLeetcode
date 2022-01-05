import java.util.Arrays;

//62. 不同路径
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
//问总共有多少条不同的路径？
//思路1 dp

public class PathNums {
    public int uniquePaths(int m, int n) {
   int [] dp=new int[m]; //一维dp
        Arrays.fill(dp,1);
        for(int j=n-2;j>=0;j--){
            for(int i=m-2;i>=0;i--){
                dp[i]=dp[i]+dp[i+1];
            }
        }
            return dp[0];
    }
    public int uniquePaths2(int m, int n) {
        //思路2 ，比如3x7的地图，往下走两格，往右走六格，本质上是个排列数的数学问题
// A(m+n)(m+n)/A(m)(m)/A(n)(n)
        return 0;
    }
}

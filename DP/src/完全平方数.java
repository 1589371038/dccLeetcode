/**
 *279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 思考欸，任何一个数，最大就是111111 n个嘛
 * 然后它的最优解，比如 12 是444，那 去掉尾巴上的4， 剩下的8由44组成，这就是最优子问题啊
 * 但是不知道组成它的最优解，最大的一个平方数是哪一个，所以都有可能
 * dp[n]表示数字n的最少完全平方数组合
 * dp[12]-  如果是9 那就是dp[3]+1  如果是4那就是dp[8]+1 如果是1那就是dp[11]+1
 * 总之，遍历小于n的平方数，取这几个dp+1中的最小
 * 边界条件：dp[0]=1 dp[1]=1
 */

public class 完全平方数 {
    public static int numSquares(int n) {
        int[] dp =new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] =i; //11111的情况，初始化
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(3));
       for(int i=1;i<=9;i++){
           System.out.println(numSquares(i));
       }
    }
}

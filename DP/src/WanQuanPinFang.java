//279. 完全平方数
//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

public class WanQuanPinFang {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;

            for (int j = 1; i - j * j > 0;j++){
                dp[i]=Math.max(dp[i-j*j]+1,dp[i]);
        }
    }
        return dp[n];
}}

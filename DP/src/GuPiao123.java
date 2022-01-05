//123. 买卖股票的最佳时机 III
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
//注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
// dp[i][k][0/1] k表示还剩下几次交易的机会，0/1 表示是否持有
public class GuPiao123 {
    public int maxProfit(int[] prices) {
int[][][]dp=new int[prices.length][3][2];
//初始化  dp[-1]的初始化在后面判断
        for(int i=0;i<prices.length;i++){
            dp[i][0][0]=0;
            dp[i][0][1]=-Integer.MAX_VALUE;
        }
        for(int i=0;i<prices.length;i++){
            for(int k=2;k>=1;k--){
                dp[i][k][0]=Math.max(i==0?0:dp[i-1][k][0],i==0?Integer.MIN_VALUE:dp[i-1][k][1]+prices[i]);
                dp[i][k][1]=Math.max(i==0?Integer.MIN_VALUE:dp[i-1][k][1],i==0?-prices[i]:dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[prices.length-1][2][0];

    }
}

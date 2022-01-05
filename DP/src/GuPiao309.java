//309. 最佳买卖股票时机含冷冻期
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
//设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
public class GuPiao309 {
    public int maxProfit(int[] prices) {
int [][]dp=new int[prices.length+1][2];//0为前一天，01为第一天
        dp[0][0]=0;
        dp[0][1]=-Integer.MAX_VALUE;//初始化
        for(int i=1;i<=prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
                    dp[i][1]=Math.max(dp[i-1][1],i>=2?dp[i-2][0]-prices[i-1]:-prices[i-1]);
        }
        return dp[prices.length][0];

    }
}

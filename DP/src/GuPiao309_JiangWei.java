//309. 最佳买卖股票时机含冷冻期
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
//设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

//降维版
public class GuPiao309_JiangWei {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int value_0=0;
        int value_1=Integer.MIN_VALUE;
        int pre_0=0;
        for(int i=0;i<prices.length;i++){
            int tempt=value_0;
            value_0=Math.max(value_0,value_1+prices[i]);
            value_1=Math.max(value_1,pre_0-prices[i]);
            pre_0=tempt;
        }
        return value_0;

    }
}

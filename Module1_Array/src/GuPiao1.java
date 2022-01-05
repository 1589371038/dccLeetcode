//121. 买卖股票的最佳时机
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
//
//注意：你不能在买入股票前卖出股票。
//双指针，都从最左边开始，如果卖出价格高于买入，计算，最大
//如果卖出价格低于买入，则买入day重置为此卖出day
public class GuPiao1 {
    public int maxProfit(int[] prices) {
int buyDay=0;
int sellDay=0;
int largestProfit=0;
int thisProfit=0;
for(sellDay=0;sellDay<prices.length;sellDay++){
    if(prices[sellDay]<prices[buyDay]){
        buyDay=sellDay;
    }
    thisProfit=prices[sellDay]-prices[buyDay];
    largestProfit=Math.max(thisProfit,largestProfit);
}
return largestProfit;
    }
}

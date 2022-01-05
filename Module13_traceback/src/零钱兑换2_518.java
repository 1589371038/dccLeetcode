/**
 * 518. 零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 *  深度优先遍历，画树，这个解决方法类似组合总数，但是超时了零钱兑换2_518
 */

public class 零钱兑换2_518 {
    private  int totalCount = 0;
    public int change(int amount, int[] coins) {
        if(amount == 0 ){
            return 1;
        }
        if(coins.length == 0){
            return 0;
        }
        int indexBegin = 0;
        dfs(coins,amount, indexBegin);
        return  totalCount;
    }

    private void dfs(int[] coins, int amount, int indexBegin) {
        if(amount<0){
            return;
        }
        if(amount == 0){
            totalCount++;
            return;
        }
        for(int i = indexBegin; i<coins.length; i++){
            dfs(coins, amount-coins[i],i);
        }
    }
}

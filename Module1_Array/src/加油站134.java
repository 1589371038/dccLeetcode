/**
 * 134. 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * 输出: 3
 *
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 *
 *
 * 思考：gas-cos 是每一个加油站的纯油量
 * 如果从一个节点出发到终点，纯油量一直叠加，从未是负数，那就可以成功！
 * //这个思路复杂度是n^2 超时了
 */

public class 加油站134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] pure = new int[gas.length];
        for(int i=0;i<pure.length;i++){
            pure[i]=gas[i]-cost[i];
        }
     a:   for(int i=0;i<pure.length;i++){//以每一个加油站为起点
            int pureCount=0;
            for(int j=i, count =0;count<pure.length;j=(j+1)%pure.length,count++){
                pureCount+=pure[j];
                if(pureCount<0){
                    continue a; //如果油不够了，换下一个起点
                }
            }
            return i; //如果环游一周还没有遇到没油，说明成功了
        }
        return -1;
    }
}

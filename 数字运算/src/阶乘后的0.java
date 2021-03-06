/**
 *172. 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 *
 * 思路啊：就是计算1-n有多少个0，2，5， 2和5的较小者就是多出来的0的个数
 * 0的个数：1*n/10 加上  1*(n/100) 虽然100 200有两个0但是计算个位的0已经算过了
 *         加上 1*(n/1000)..
 *  2的个数 从2-4-6-8-10-12-14-16  4算两个2  8算3个2
 *          先计算至少有一个2的个数：n/2
 *          有至少两个2的个数：n/4
 *          有至少三个2的个数：n/16
 *          .............
 *          直到2^x>n
 *          所有个数相加
 *  5的个数：5,10,15,20,25,30,35,40,...
 *  突然发现，计算2和5的过程中，10 也包含进来了，似乎不用计算10了！！
 *          至少一个5的个数 n/5
 *          至少两个5的个数 n/25
 *          ...
 *          直到5^x>n
 *          开干
 */

public class 阶乘后的0 {
    public int trailingZeroes(int n) {
        int x=1;
        int sumOf2=0;
        while (Math.pow(2,x)<=n){
            sumOf2+=n/Math.pow(2,x);
            x++;
        }
        int y=1;
        int sumOf5=0;
        while (Math.pow(5,y)<=n){
            sumOf5+=n/Math.pow(5,y);
            y++;
        }
        return Math.min(sumOf2,sumOf5);
    }
}

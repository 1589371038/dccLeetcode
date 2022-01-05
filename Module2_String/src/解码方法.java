import java.util.HashSet;
import java.util.Set;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 思路：假设calNum(s,i)表示从第i位开始的解码数量
 * 则calNum(s,i) = calNum(s,i+1)+calNum(s,i+2) //如果满足能分成1-9 及10-26的情况
 * 终止条件：1.s[i]=0 则一位数两位数都不行，return0   2 i=len i=len-1 return 1
 *  递推条件 2.s[i]!=0至少可以分一位,
 *       3.分第二位的条件: i+1不越界，且i和i+1构成的字符串在10-26之间
 *       注意，这种至上而下的方法会有重复计算！所以用一个hashmap记录i处的结果，能查到就剪枝了！
 *
 *       思考：有没有自下而上的方法，可以啊，递推思路差不多！
 */

public class 解码方法 {
    //解法1自上而下,不剪枝      leetcode计算果然超时！！！
    public int numDecodings(String s) {
        if(s==null||s.length()<1){
            return 0;
        }
        Set<String> liangWeiShu = new HashSet<>();//把10-26存入set用于判断是否可以两位数解码分流
        for(int num=10;num<=26;num++){
            liangWeiShu.add(String.valueOf(num));
        }
        return calNums(s,0,liangWeiShu);

    }

    private int calNums(String s, int i, Set<String> liangWeiShu) {
        int result=0;
        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }else {
            //至少一位可以分流
            result+=calNums(s,i+1, liangWeiShu);
            if(i+1<=s.length()-1&&liangWeiShu.contains(s.substring(i,i+2))){ //此条件下两位数可以分流
                result+=calNums(s,i+2, liangWeiShu);
            }
            return result;
        }
    }
}

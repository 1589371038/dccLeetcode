import java.util.Arrays;

/**
 * 372. 超级次方
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 *输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 *
 * a^b %c 可以典型地用快速幂计算，但是这里b是数组，每个数字0-9，考虑怎么计算b%2和?
 *
 * 最后： b这个数组实在太大了，每次除以2，最后计算时间复杂度还挺高的
 * 设 b 为 2,3,4,5, a=5
 * 5^2345 = ((5^234)^10)*5^5;   这样的话每次处理一个位，很快
 * 见：超级次方2
 */

public class 超级次方 {
    public static int superPow(int a, int[] b) {
        int [] zero = new int[b.length];
        int multi = 1;
    while (!Arrays.equals(b,zero)){
        if(b[b.length-1]%2==0){ //如果指数是偶数
            a=((a%1337)*(a%1337)%1337);
            calDivide2(b);
        }else {
            multi=(multi*(a%1337)%1337);
            a=((a%1337)*(a%1337)%1337);
            calDivide2(b);
        }
    }
    return multi;
    }
    public static void calDivide2(int[] b ){
        int carry=0;
        for(int i=0; i<b.length; i++){
            int nextCarry=(carry*10+b[i])%2;
            b[i]=(carry*10+b[i])/2;
            carry = nextCarry;

        }
    }

    public static void main(String[] args) {
        calDivide2( new int[]{1, 0});
        int i = superPow(2, new int[]{1, 0});
    }
}

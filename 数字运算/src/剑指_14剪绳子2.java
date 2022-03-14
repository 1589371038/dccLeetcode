/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 思路 k=n/3 余数=0 则 3^k   余数=2 则 3^k * 2  余数=1 则 3^k-1 * 4
 * 需要取摸，用快速幂的过程取模
 */

public class 剑指_14剪绳子2 {
    public static int cuttingRope(int n) {
        if(n==2){
            return 1;
        }else if(n==3){
            return 2;
        }
        int k = n/3;
        int yu = n%3;
        if(yu == 0){
            return (int) pow(3, k);
        }else if(yu == 2){
            return (int)((pow(3, k) * 2)%1000000007);
        }else {
            return  (int)((pow(3,k-1) * 4)%1000000007);
        }

    }

    private static long  pow(long i, long k) {
        long res = 1;
        while (k>0){
            if(k%2==1){
                res = (res*i)%1000000007;
                i=(i*i)%1000000007;
                k=(k-1)/2;
            }else {
                i=(i*i)%1000000007;
                k=k/2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long res = pow(2, 9);
        System.out.println(res);
        int i = cuttingRope(127);
        System.out.println(i);
    }
}

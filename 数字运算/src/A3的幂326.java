/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 * 进阶：你能不使用循环或者递归来完成本题吗？
 * 思考：递归的话，当能整除3的时候一直除以3， 看最后的结果是否=1.
 */

public class A3的幂326 {
    //递归写法
    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        while (n%3==0){
            n=n/3;
        }
        return n==1;
    }
    //非递归写法：找到int中3的幂最大的数， 只有3的幂会被它整除
    //首先3的幂必被它整除，其次其他书必不被它整除
    public boolean isPowerOfThree1(int n) {
        if(n<=0){
            return false;
        }
        int max = 1162261467;
        return (max%n)==0;
    }
}

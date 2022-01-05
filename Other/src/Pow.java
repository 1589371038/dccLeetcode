//50. Pow(x, n)
//实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//-100.0 < x < 100.0
//n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
//思路 先分正负
//再 除以2 除以2
public class Pow {
    public double myPow(double x, int n) {
        long nn=n;
        return  nn>=0?realPow(x,nn):1/realPow(x,-nn);

    }

    private double realPow(double x, long l) {
        if(l==0){
            return 1;
        }
        double result=realPow(x,l/2);
        result=result*result;
        if(l%2==1){
            result=result*x;
        }
        return result;
    }
}

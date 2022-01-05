/**
 * 69. Sqrt(x)
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
//
public class sqrtx {
    //思路1，一直加，试探
    public int mySqrt(int x) {
        int i = 1;
        while((long)i*i<=x){
            i++;
        }
        return i-1;
    }
    //思路2：一位一位地加太逊啦，建议从1到x二分查找  寻找最大的i使得i*i<=x
    public static int mySqrt2(int x) {
        int l=0;
        int r=x;
        int result=0;
        while (l<=r){
            int mid =(l+r)/2;
            if((long)mid*mid<=x){
                result=mid;
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        mySqrt2(1);
    }
}

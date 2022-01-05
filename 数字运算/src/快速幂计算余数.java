/**
 * moon  用快速幂计算(a^b)%c
 */

public class 快速幂计算余数 {
    public static int pow (int a, int b, int c){
        int multi=1;//快速幂指数为基数时先
        while (b!=0){
            if(b%2==0){
                a=((a%c)*(a%c))%c;
                b=b/2;
            }else {
                multi=(multi*a)%c;
                a=((a%c)*(a%c))%c;
                b=(b-1)/2;
            }

        }
        return multi;
    }

    public static void main(String[] args) {
        int pow = pow(2, 10, 1000);
        System.out.println(pow);
    }
}

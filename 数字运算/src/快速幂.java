/**
 * moon  用快速幂计算a^b
 */

public class 快速幂 {
    public static int pow (int a, int b){
        int multi=1;//快速幂指数为基数时先
        while (b!=0){
            if(b%2==0){
                a=a*a;
                b=b/2;
            }else {
                multi=multi*a;
                a=a*a;
                b=(b)/2;
            }

        }
        return multi;
    }

    public static void main(String[] args) {
        int pow = pow(5, 5);
        System.out.println(pow);
        System.out.println(cal1(1645,48));
        System.out.println(cal2(1645,48));
    }
    public static int  cal1(int a, int b){
        return (a%b)*(a%b)%48;
    }
    public static int  cal2(int a, int b){
        return (a*a)%b;
    }
}

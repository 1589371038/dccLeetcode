/**
 * moon
 */

public class 超级次方2 {
    static int MOD = 1337;

    public static int superPow(int a, int[] b) {
        return calculate(a, b, b.length - 1);
    }

    private static int calculate(int a, int[] b, int i) {
        if (i == -1) {
            return 1;
        }
        return pow(calculate(a, b, i - 1), 10) * pow(a, b[i])%MOD;
    }

    private static int pow(int a, int b) { //快速幂计算a^b
        if (a == 0) {
            return 0;
        }
        int multi = 1;
        a = a % MOD;
        while (b != 0) {
            if (b % 2 == 0) {
                a = (a * a) % MOD;
                b = b / 2;
            } else {
                multi = (multi * a) % MOD;
                a = (a * a) % MOD;
                b = b / 2;
            }
        }
        return multi;
    }

    public static void main(String[] args) {
        superPow(2, new int[]{1,0});
    }
}

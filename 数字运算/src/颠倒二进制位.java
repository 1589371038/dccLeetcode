/**
 * moon
 */

public class 颠倒二进制位 {
    public int reverseBits(int n) {
        int res = 0;
        int wei = 0;
        while (n != 0) {
            res = res | (n & 1) << (31 - wei);
            n = n >>> 1;
            wei++;
        }
        return res;
    }
}

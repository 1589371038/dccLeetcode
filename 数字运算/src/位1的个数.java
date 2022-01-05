/**
 * moon
 */

public class 位1的个数 {
    public static int hammingWeight(int n) {
        int count = 0;
        for(int i=1,t=0;t<32;i=i<<1,t++){
            if((n&i)!=0){ //如果是1000000000 也就是说Math.min，那相与结果就是负数
                count++;
            }
        }
        return count;
    }
    //计算1的个数还有个方法，每次n=n&n-1都会少一个1
    public static int hammingWeight2(int n) {
        int count = 0;
        while (n!=0){
            n=n&n-1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = hammingWeight(-3);
        System.out.println(i);
    }

}

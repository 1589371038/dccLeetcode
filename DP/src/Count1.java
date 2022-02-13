//338. 比特位计数
//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
//有规律的哦
public class Count1 {
    public int[] countBits(int num) {
        int[] result=new int[num+1];
        if(num==0){
            return result;
        }
        result[1]=1;
        int b=2;
       int i=1;//从2开始赋值
       w: while(i<=num){
            for(int j=1;j<=b;j++){
                i++;
                result[i]=result[i-b]+1;
                if(i==num){
                    break w;
                }
            }
            b=b<<1;
        }
        return result;
    }

    /**
     * 方法1：效率nlogn  x = x& x-1 会让x的1减少一个
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        int[] result = new int[num+1];
        for(int i=1; i<=num; i++){
            int count = 0;
            int x = i;
            while (x != 0){
                x = x & (x-1);
                count++;
            }
            result[i] = count;
        }
        return  result;
    }
    /**
     * 方法1：效率n
     * 动态规划  大数的结果可以由小数推过来
     * 比如 111011 -> 5个  11101->4个 + 个位是1 1个
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] result = new int[num+1];
        for(int i=1;i<=num;i++){
            result[i] = result[i>>1]+(i&1);
        }
        return result;
    }


}

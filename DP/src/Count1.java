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

}

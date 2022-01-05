import java.util.Arrays;

// 204 统计小于非负整数n的质数数量
//暴力：遍历，每一个用循环判断是否是素数
//改进：用一个boolean[] 判断是否为素数 先默认都是true
//外循环：从2到n-1,每个都执行判断素数，若为素数则进行内循环给后面的倍值赋false
//外循环改进:从2 到sqrt(n)就行了
//内循环：素数乘大于2的数，变为非素数  i*2 *3 *4 ..一直到n
//内循环改进：从i^2开始一直到n，因为i*2 i*3..i*n-1已经被前面的给改过了
public class 计数质数 {
    public int countPrimes(int n) {
boolean[] isPrime=new boolean[n];
        Arrays.fill(isPrime,true);
        for(int i=2;i*i<n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<n;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){   //从2开始算，因为0和1被错误的置为true，其实不是质数！！
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }
}

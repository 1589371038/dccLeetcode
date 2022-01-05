import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 * 思路：按照逻辑来，用个set判断重复，如果重复就false 如果=1就true；
 */

public class 快乐数202 {
    public boolean isHappy(int n) {
        //怕超过最大，转long
        Set<Long> set =new HashSet<>();
        long m =  n;
        while (!(set.contains(m)||m==1)){//终止条件出现1或者重复
            set.add(m);
            m=transform(m);
        }
        if(m==1){
            return true;
        }else return false;

    }

    private long transform(long m) {//各位平方相加
        long result = 0;
        while (m!=0){
            result+=Math.pow(m%10,2);
            m=m/10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(2^2);
    }
}

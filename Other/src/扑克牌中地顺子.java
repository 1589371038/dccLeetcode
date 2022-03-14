import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 思路：关键是王怎么计算：其实就是把非王牌排序，然后计算间隔数，比如 1 2 5 间隔数=2
 * 王牌数> =间隔数 就能凑成顺子！
 *
 * 有个bug：如果牌有重复数就计算失误了，所以需要剔除重复数
 */

public class 扑克牌中地顺子 {
    public boolean isStraight(int[] nums) {
        List<Integer> notZero = new ArrayList<>();
        int zeroCount = 0;
        for(int num:nums){
            if(num == 0){
                zeroCount++;
            }else notZero.add(num);
        }

        Collections.sort(notZero);
        if(hasSame(notZero)){
            return false;
        }
        int splitCount = countSplit(notZero); // 计算连续牌中的缺失数
        return zeroCount>=splitCount;
    }

    /**
     * 如果有重复数，不能顺子
     * @param notZero
     * @return
     */
    private boolean hasSame(List<Integer> notZero) {
        for(int i=0; i<notZero.size()-1; i++){
            if(notZero.get(i).equals(notZero.get(i + 1))){
                return true;
            }
        }
        return false;
    }

    private int countSplit(List<Integer> notZero) {
        int count = 0;
        for(int i=0; i<notZero.size()-1; i++){
            count += notZero.get(i+1)-notZero.get(i)-1;
        }
        return count;
    }
}

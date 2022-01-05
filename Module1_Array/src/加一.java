/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 思路1：从后到前，+1%10如果！=0，结束，直接输出
 * 如果=0，到前一位继续+1
 */

public class 加一 {
    public int[] plusOne(int[] digits) {
        for (int i =digits.length-1;i>=0;i--){
            digits[i]=(digits[i]+1)%10;
            if(digits[i]!=0){
                return digits;
            }
        }
        //如果到最后一位，还是0，说明是999-1000地情况
        int []result = new int[digits.length+1];
        result[0]=1;
        return result;
    }

}

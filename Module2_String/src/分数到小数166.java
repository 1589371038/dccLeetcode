import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 如果存在多个答案，只需返回 任意一个 。
 *
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 *
 * 除法很简单，先算整数部分，然后小数部分就是余数不断*10除以被除数，计算下一位结果
 * 至于无限循环，肯定能找到，因为只要再次出现相同的余数就是循环的首位和末尾
 * 在首位加上(
 *
 * 1.注意考虑正负号啊喂！
 * 2.-int.max / -1会越界啊喂
 * 3.如果被除数是-int.max，转成正数还是它，所以用long来接
 */

public class 分数到小数166 {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if((numerator>0&&denominator<0)||(numerator<0&&denominator>0)){//一个负数
            sb.append("-");
        }
        long numeratorL = numerator;
        long denominatorL = denominator;
        numeratorL=Math.abs(numeratorL);
        denominatorL=Math.abs(denominatorL);
        sb.append(numeratorL/denominatorL);
        long yu = numeratorL%denominatorL;
        Map<Long,Integer> map = new HashMap<>();//记录余数出现的位置
        if(yu==0){
            return sb.toString();
        }else {//余数不为0
            sb.append("."); //小数点
            map.put(yu,sb.length());
            yu = yu*10;
        }
        while (yu!=0){
            sb.append(yu/denominatorL);
            yu=yu%denominatorL;
            if(map.containsKey(yu)){//如果出现了余数循环
                String substring1 = sb.substring(0,map.get(yu));//循环体前的
                String substring2 = sb.substring(map.get(yu));//循环体后的
                return substring1+"("+substring2+")";
                //return String.format("%s(%s)",substring1,substring2);
            }
            map.put(yu,sb.length());
            yu=yu*10;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = fractionToDecimal(-1, -2147483648);
        System.out.println(s);
    }
}

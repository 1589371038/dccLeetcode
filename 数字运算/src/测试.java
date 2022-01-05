/**
 * moon
 */

public class 测试 {
    public static void main(String[] args) {
        基本计算器3_772 s = new 基本计算器3_772();
        int result = s.calculate("(2+6* 3+5- (3*14/7+2)*5)+3");
        int result2 = s.calculate("2*(5+5*2)/3+(6/2+8)");
        System.out.println(result);
        System.out.println(result2);
    }
}

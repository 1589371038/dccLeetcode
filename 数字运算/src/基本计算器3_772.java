import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 现基本计算器以计算简单表达式字符串。
 * <p>
 * 表达式字符串可以包含左括号（和右括号）、加号+或减号、非负整数和空格。
 * <p>
 * 表达式字符串只包含非负整数、+、-、*、/运算符、括号和空格。整数除法应该截断为零。
 * <p>
 * 您可以假定给定的表达式总是有效的。所有中间结果将在范围内[-2147483648，2147483647]
 * <p>
 * "1 + 1" = 2
 * " 6-4 / 2 " = 4
 * "2*(5+5*2)/3+(6/2+8)" = 21
 * "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 * ————————————————
 * 和基本计算器2相比来说加了空格，带来的问题是
 * 1空格后接负数(-3+2)不好读，变成(0-3+2)
 * 2 空格要优先处理，遇到)把操作符里的操作一直做到(
 * <p>
 * 常规思路：三叶的思路概括为两个栈的双向清理
 * 1.从左到右  建栈的时候，每次push操作符，保证把>=此操纵符优先级的操作都可以执行了。
 * 2.从右到左 栈建完之后，操作符从左到右(栈底到栈顶) 肯定是优先级递增的，那从栈顶开始不断计算就ok了
 * <p>
 * 注意点：1开始的负数和(的负数
 * 2去空格
 * 建栈的时候 1数字不断往后读，放进数字栈
 * 2 (放入操作栈
 * 3 )放入前执行操作栈 直到(  其实就是一次从右到左的清理
 * 4 +-/*放入前执行栈里优先级大于等于操作符的
 * 建完栈后 执行剩下所有操作栈
 */

public class 基本计算器3_772 {
    Map<Character, Integer> map = new HashMap<>();

    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        s = s.replaceAll(" ", "");
        s = s.replace("(-", "(0-");
        if (s.startsWith("-")) {
            s = "0" + s;
        }//预处理结束
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                int j = i;
                while (j < chars.length && Character.isDigit(chars[j])) {
                    j++;  //j一直增加到不是数字为止
                }
                nums.push(Integer.parseInt(s.substring(i, j)));
                i = j - 1;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty()&&ops.peek()!='('){ //从栈顶到栈底，在(之前的操作都执行
                    calcOneop(nums,ops);
                }
                ops.pop(); //把 ( 去掉

            } else { //加减乘除
                //把优先级高的都执行了
                while (!ops.isEmpty() && map.containsKey(ops.peek())/*是操作符才能比较*/&&map.get(ops.peek()) >= map.get(c)) {
                    calcOneop(nums, ops);
                }
                ops.push(c);
            }
        }
        //入栈结束，开始出栈
        while (!ops.isEmpty()){
            calcOneop(nums,ops);
        }
        return nums.pop();
    }

    //从操作数中拿出两个，操作拿出一个来计算,并放入数字栈
    private void calcOneop(Deque<Integer> nums, Deque<Character> ops) {
        int b = nums.pop();
        int a = nums.pop();
        char op = ops.pop();
        int ands = 0;
        if (op == '+') {
            ands = a + b;
        } else if (op == '-') {
            ands = a - b;
        } else if (op == '*') {
            ands = a * b;
        } else if (op == '/') {
            ands = a / b;
        } else {
            throw new RuntimeException("不支持此操作符");
        }
        nums.push(ands);
    }
}

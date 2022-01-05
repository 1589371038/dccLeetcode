import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 思考：典型的栈处理，遇到运算符时取出栈中前两个数字和运算符做运算然后返回栈中
 * 注意取出的顺序
 */

public class 逆波兰表达式150 {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        Deque<String> stack = new ArrayDeque<>();
        for(int i=0;i<tokens.length;i++){
            if(!operators.contains(tokens[i])){ //如果不是运算符
                stack.push(tokens[i]);
            }else {//如果是运算符
                String num2 = stack.pop();
                String num1 = stack.pop();
                String result = operate(num1,num2,tokens[i]);
                stack.push(result);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private String operate(String num1, String num2, String operator) {
        if(operator.equals("+")){
            return String.valueOf(Integer.parseInt(num1)+Integer.parseInt(num2));
        }
        if(operator.equals("-")){
            return String.valueOf(Integer.parseInt(num1)-Integer.parseInt(num2));
        }
        if(operator.equals("*")){
            return String.valueOf(Integer.parseInt(num1)*Integer.parseInt(num2));
        }
        if(operator.equals("/")){
            return String.valueOf(Integer.parseInt(num1)/Integer.parseInt(num2));
        }
        throw new RuntimeException("操作符非法");
    }
}

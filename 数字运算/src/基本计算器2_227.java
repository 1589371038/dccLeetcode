import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 * 简单版，只考虑加减乘除
 *
 * 题解：
 * https://leetcode-cn.com/problems/basic-calculator-ii/solution/shi-yong-shuang-zhan-jie-jue-jiu-ji-biao-c65k/
 * 思路：宫水三叶提供的思路，双栈(数字加其他)+优先级操作符(每push一个操作符之前把优先级更高或者相同的操作符做执行)
 *
 * 注意点：1第一个数字如果是-1，无法读取数字
 *        2读取数字：发现是数字后要向后读一直到不是数字
 */

public class 基本计算器2_227 {
    Map<Character,Integer> map = new HashMap<>();
    public int calculate(String s) {
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);//优先级

        s=s.replaceAll(" ","");//去掉空格
        if(s.startsWith("-")){ //队首负号
            s="0"+s;
        }
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            if(Character.isDigit(c)){//如果是数字,往后一直找数字
                int j = i;
                while (j<chars.length&&Character.isDigit(chars[j])){
                    j++;
                }
                nums.push(Integer.parseInt(s.substring(i,j)));
                i=j-1;//i本来应该是j(第一个不为数字的) 但是for循环i要++
            }else {//操作符
                while (!ops.isEmpty()&&map.get(ops.peek())>=map.get(c)){  //把优先级大于等于当前操作符的，都计算了
                    calc(nums,ops);
                }
                ops.push(c);//算完前面的，push操作符
            }
        }
        //弄完以后，栈里可能还有操作符，算完
        while (!ops.isEmpty()){
            calc(nums,ops);
        }
        return nums.pop();//只剩一个数字
    }

    private void calc(Deque<Integer> nums, Deque<Character> ops) {
        if(nums.size()<2||ops.size()<1){
            return;
        }
        int b = nums.pop(); //注意a和b的顺序
        int a = nums.pop();
        Character op = ops.pop();
        int ands = 0;
        if(op=='+'){
            ands = a+b;
        }else if(op=='-'){
            ands = a-b;
        }else if(op=='*'){
            ands=a*b;
        }else if(op=='/'){
            ands=a/b;
        }else {
            throw new RuntimeException("输入表达式中有非法操作符");
        }
        nums.push(ands);
    }
}

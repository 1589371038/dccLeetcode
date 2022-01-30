import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 思路1：dp
 * 思路2：栈  栈可以寻找有效括号，在消括号的过程中，记录有效的括号下标，然后遍历一次记录连续的最长有效括号！
 * 栈存储括号+下标的二元组
 */

public class 最长有效括号32 {
    public int longestValidParentheses(String s) {
        boolean isValid[] = new boolean[s.length()];
        Deque<combo> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(new combo('(',i));
            }else { //如果是)就要消除左括号(
                combo combo = stack.peek();
                if(combo!=null&&combo.getC()=='('){
                    isValid[i]=true; //右括号消除了
                    isValid[combo.getIndex()]=true; //左括号消除了
                    stack.pop();
                }else {
                    stack.push(new combo(')',i));
                }
            }
        }
        //寻找最大的连续true
        int max=0;
        int cal=0;
        for(int i=0;i<isValid.length;i++){
            if(isValid[i]){
                cal++;
                max=Math.max(max,cal);
            }else {
                cal=0;
            }
        }
        return max;
    }
    //二元组
    class combo{
        Character c;
        Integer index;

        public combo(Character c, Integer index) {
            this.c = c;
            this.index = index;
        }

        public Character getC() {
            return c;
        }

        public void setC(Character c) {
            this.c = c;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }
    }
}

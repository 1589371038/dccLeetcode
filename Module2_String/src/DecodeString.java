import java.util.Stack;

//394. 字符串解码
//给定一个经过编码的字符串，返回它解码后的字符串。
//编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
//一般都是用栈啦
public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack=new Stack<>();
        char[] chars=s.toCharArray();
        StringBuilder sb=new StringBuilder();//用于存括号中的内容
        StringBuilder integer=new StringBuilder();//用于存次数
        for(int i=0;i<chars.length;i++){
            if(chars[i]!=']'){
                stack.push(chars[i]);
            }
            else{ //如果是],则把括号内的放进sb
                while(stack.peek()!='['){
                    sb.append(stack.pop());
                }
                stack.pop();//把[pop
                while(!stack.empty()&&String.valueOf(stack.peek()).matches("[0-9]")){
                    integer.append(stack.pop());
                }
                int numMulti=Integer.parseInt(integer.reverse().toString());//次数
                sb.reverse();
                String sbs=sb.toString();
                for(int j=1;j<numMulti;j++){
                    sb.append(sbs);            //按照倍数乘
                }
                for(int j=0;j<sb.length();j++){  //乘好的push回stack
                    stack.push(sb.charAt(j));
                }
              sb.delete(0,sb.length()); //一次做完就清空
              integer.delete(0,integer.length());//一次做完就清空
            }
        }
        //收集结果，反转，输出
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        String result=sb.reverse().toString();
return result;
    }
}

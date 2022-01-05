import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//计算器，1将前缀表达式转换成后缀表达式2解析后缀表达式得到答案。
public class Calculator1 {
    //1 通过两个操作数和一个操作符计算
    public float calOne(String caoZuoFu,String num1,String num2 ){
        float fnum1=Float.parseFloat(num1);
        float fnum2=Float.parseFloat(num2);
        switch (caoZuoFu){
            case "+":
                return  fnum1+fnum2;
            case "-":
                return  fnum1-fnum2;
            case "*":
                return  fnum1*fnum2;
            case "/":
                return  fnum1/fnum2;
        }
        return (float) -0;
    }
    //2 通过后缀表达式计算结果,后缀表达式用string【】数组省的不知道数字有几位
    public float calPost(String[] postString){
        //需要区分数字和操作数，不考虑小数点，要考虑多位数。
        Stack<String> stack=new Stack<String>();
        int index=0;
        //从头到尾扫描
        while(index<postString.length){
            //如果是加减乘除,
            if(postString[index].matches("[+\\-*/]")){
                String num2=stack.pop();
                String num1=stack.pop();
                float result=calOne(postString[index],num1,num2);
                stack.push(Float.toString(result));
                index++;
            }
            //如果是数字
            else{
                stack.push(postString[index]);
                index++;
            }
        }
        return Float.parseFloat(stack.pop());
    }
    // 3 中缀转后缀，用栈
    String[] mid2PostString(String midString){
        int index=0;
        List<String> postStrings=new ArrayList<>();
        Stack<String> caoZuoFus=new Stack<>();

        while(index<midString.length()){
            //如果是操作符+-,则需要弹出优先级相等或更高的(+-*/都要先出来)，直到"("
            if(midString.charAt(index)=='+'||midString.charAt(index)=='-'){
               while(!caoZuoFus.empty()&&(caoZuoFus.peek().matches("[+\\-*/]"))){
                   postStrings.add(caoZuoFus.pop());
               }
               caoZuoFus.push(String.valueOf(midString.charAt(index)));
               index++;
            }
            //如果是操作符*/,则需要弹出优先级相等或更高的(*/都要先出来)，直到"("
            else if(midString.charAt(index)=='*'||midString.charAt(index)=='/'){
                while(!caoZuoFus.empty()&&(caoZuoFus.peek().matches("[*/]"))){
                    postStrings.add(caoZuoFus.pop());
                }
                caoZuoFus.push(String.valueOf(midString.charAt(index)));
                index++;
            }
            //如果是"("
            else if(midString.charAt(index)=='('){
                caoZuoFus.push("(");
                index++;
            }
            //如果是“）”把括号内的内容都弹出去
            else if(midString.charAt(index)==')'){
                //把（之前的都pop
                while(!caoZuoFus.peek().equals("(")){
                    postStrings.add(caoZuoFus.pop());
                }
                //把（也pop
                caoZuoFus.pop();
                index++;
            }
            //如果是数字，需要找到多位数有多少位再放进去
            else {
                int indexStart=index;
                while(index<midString.length()&&String.valueOf(midString.charAt(index)).matches("[0-9]")){
                    index++;
                }
                String num=midString.substring(indexStart,index);
                postStrings.add(num);
            }
        }
        while(!caoZuoFus.empty()){
            postStrings.add(caoZuoFus.pop());
        }
        return (String[]) postStrings.toArray(new String[0]);

    }


}

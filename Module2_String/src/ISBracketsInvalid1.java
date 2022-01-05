import java.util.HashMap;
import java.util.Stack;

public class ISBracketsInvalid1 {
//       题目：20.有效的括号
//    方法：用栈从内部解决，闭括号前必须是对应的开括号，否则失败，若对应，则pop。 最后栈不为空也失败
    private  HashMap<Character,Character> map;
    public ISBracketsInvalid1(){
        this.map=new HashMap<>();
        this.map.put(')','(');
        this.map.put(']','[');
        this.map.put('}','{');
    }
public boolean isValid(String s) {
    Stack<Character> stack=new Stack<>();
    for(int i=0;i<s.length();i++){
        if(map.containsKey(s.charAt(i))){
            char top=stack.isEmpty()?'*':stack.pop();
            if(top!=map.get(s.charAt(i))){
                return false;
            }
        }
        else{
            stack.push(s.charAt(i));
        }
    }
//    if(!stack.isEmpty()){
//        return false;
//    }
//    return true;
    return stack.isEmpty();
}
}

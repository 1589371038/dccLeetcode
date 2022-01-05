import java.util.Stack;

public class Temprature {
//    根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
//
//例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//
//提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
//
//思路：用栈从尾到头遍历，记录比t【i】大的数组index，若栈中数字比t[i]小，则pop掉，目标就是栈顶的index-i，然后把ipush进去
public int[] dailyTemperatures(int[] T) {
int[]result=new int[T.length];
    Stack<Integer> stack=new Stack<>();
    for(int i=T.length-1;i>=0;i--){
        while(!stack.empty()&&T[stack.peek()]<=T[i]){
            stack.pop();
        }
        result [i]=stack.empty()?0:stack.peek()-i;
        stack.push(i);
    }
    return result;
}
}

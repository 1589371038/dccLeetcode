import java.util.Stack;

/**
 * 739. 每日温度
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 思考：就是每个位置找往右看比自己大的第一个数字的位置嘛，单调栈！
 * 从右往左，单调减
 */

public class 每日温度 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[]result =new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=temperatures.length-1;i>=0;i--){
            while (!stack.empty()&&temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            result[i]=stack.empty()?0:stack.peek()-i;
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(ints);
    }
}

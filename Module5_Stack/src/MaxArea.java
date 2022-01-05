import java.util.Stack;

//84
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//        求在该柱状图中，能够勾勒出来的矩形的最大面积。
public class MaxArea {
    public int largestRectangleArea(int[] heights) {
//用单调栈找出左边第一个小的坐标和右边第一个小的坐标，然后计算每一个位置的长方形面积
        Stack<Integer> stack1 = new Stack<>();  //数组从左往右插入的单调增栈，用于找到左边比它小的第一个坐标
        int[] L = new int[heights.length];      //存储往左看，比当前数字小的第一个数字所在的坐标
        Stack<Integer> stack2 = new Stack<>();  //数组从右往左插入的单调增栈，用于找到右边比它小的第一个坐标
        int[] R = new int[heights.length];      //存储往右看，比当前数字小的第一个数字所在的坐标
        int MaxArea1 = 0; //最大面积
        //找左坐标的单调栈
        for (int i = 0; i < heights.length; i++) {
            while (!stack1.empty() && heights[stack1.peek()] >= heights[i]) {
                stack1.pop();
            }
            L[i] = stack1.empty() ? -1 : stack1.peek();
            stack1.push(i);
        }
        //找右坐标的单调栈
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack2.empty() && heights[stack2.peek()] >= heights[i]) {
                stack2.pop();
            }
            R[i] = stack2.empty() ? heights.length : stack2.peek();
            MaxArea1 = Math.max(MaxArea1, (R[i] - L[i] - 1) * heights[i]); //根据R[i]和L[i]计算矩形面积
            stack2.push(i);
        }
        return MaxArea1;
    }
    //递增单调栈代码示例
    public void stackAdd(int heights[]){
        int[] L=new int[heights.length];  //L用于记录往左看第一个比当前index小的数字所在的下标
        Stack<Integer> stack=new Stack<>(); //构造栈
        //找左坐标的单调栈
        for (int i = 0; i < heights.length; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();//递增单调栈push的时候，如果栈顶比当前数字大，就弹出
            }
            L[i] = stack.empty() ? -1 : stack.peek(); //入栈前，栈顶所在的记录，就是第一个比当前index小的数字所在的下标
            stack.push(i);  //当前数字入栈
        }

    }
}

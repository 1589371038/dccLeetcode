import java.util.Stack;

/**
 * moon
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * //solution:典型的单调栈，求每个位置往左往右看第一个比自己小的位置所在
 */

public class MaxArea1 {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int [] L = new int[heights.length];
        int [] R = new int[heights.length];
        for(int i = 0; i<heights.length; i++){ //往左看第一个比自己小的
            while (!stack1.empty()&&heights[stack1.peek()]>=heights[i]){
                stack1.pop();
            }
            L[i]= stack1.empty()?-1:stack1.peek();
            stack1.push(i);
        }
        for(int i = heights.length-1; i>=0; i--){
            while (!stack2.empty()&&heights[stack2.peek()]>=heights[i]){
                stack2.pop();
            }
            R[i]=stack2.empty()?heights.length:stack2.peek();
            stack2.push(i);
        }
        //面积等于height[i]*(R[i]-L[i]-1);
        int max = 0;
        for(int i =0; i<heights.length; i++){
            max = Math.max(max, heights[i]*(R[i]-L[i]-1));
        }
        return max;
    }

    public static void main(String[] args) {
        int i = largestRectangleArea(new int[]{1,1});
        System.out.println(i);
    }
}

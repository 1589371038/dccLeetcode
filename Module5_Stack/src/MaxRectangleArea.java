import java.util.Stack;
//85最大矩形
public class MaxRectangleArea {
    public int maximalRectangle(char[][] matrix) {
if(matrix.length==0){
    return 0;
}
int maxArea=0;
int [] dp=new int[matrix[0].length];
for(int i=0;i<matrix.length;i++){
    for(int j=0;j<matrix[0].length;j++){
        dp[j]=matrix[i][j]=='0'?0:dp[j]+1;
    }
    maxArea=Math.max(maxArea,largestRectangleArea(dp));
}
return maxArea;
    }
    public int largestRectangleArea(int[] heights) {
//用单调栈找出左边第一个小的坐标和右边第一个小的坐标，然后计算每一个位置的长方形面积
        Stack<Integer> stack1=new Stack<>(); //从左往右的单调增栈，用于找到左边比它小的坐标
        int[] L=new int[heights.length];      //存储坐标的数组
        Stack<Integer> stack2=new Stack<>();
        int[] R=new int[heights.length];
        int MaxArea1=0;
        //找左坐标的单调栈
        for(int i=0;i<heights.length;i++){
            while(!stack1.empty()&&heights[stack1.peek()]>=heights[i]){
                stack1.pop();
            }
            L[i]=stack1.empty()?-1:stack1.peek();
            stack1.push(i);
        }
        //找右坐标的单调栈
        for(int i=heights.length-1;i>=0;i--){
            while(!stack2.empty()&&heights[stack2.peek()]>=heights[i]){
                stack2.pop();
            }
            R[i]=stack2.empty()?heights.length:stack2.peek();
            MaxArea1=Math.max(MaxArea1,(R[i]-L[i]-1)*heights[i]);
            stack2.push(i);
        }
        return MaxArea1;
    }
}

//42. 接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
public class Rain_42 {
    //用数组记录左边最大L[i]的和右边最大的R[i]
    //每一格雨水计算方式为(min(l[i],R[i])-height[i])(如果比它大)
    public int trap(int[] height) {
        if(height==null||height.length<3){
            return 0;
        }
    int [] left=new int[height.length];
    int [] right=new int[height.length];
    int leftMax=0;
    for(int i=1;i<left.length;i++){
        leftMax=Math.max(leftMax,height[i-1]);
        left[i]=leftMax;
    }
    for(int i=right.length-2;i>=0;i--){
       right[i]=Math.max(height[i+1],right[i+1]) ;
    }
    int sum=0;
    for(int i=1;i<height.length-1;i++){
        int min=Math.min(left[i],right[i]);
        if(min>height[i]){
            sum+=min-height[i];
        }
    }
    return sum;
    }
}

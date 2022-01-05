/**
 * moon42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 每一格的雨水水位是往左看最大的数和往右看最大的数的较小值 ， 水量是该值减去height
 */

public class 接雨水42 {
    public int trap(int[] height) {
        int[] leftSeeHighest = new int[height.length];
        int[] rightSeeHighest = new int[height.length];
        int total= 0;
        for (int i = 0; i < height.length-1; i++) {
            leftSeeHighest[i+1]= Math.max(leftSeeHighest[i], height[i]);
        }
        for(int i= height.length-1; i>0; i--){
            rightSeeHighest[i-1] = Math.max(rightSeeHighest[i],height[i]);
        }
        for(int i = 0; i<height.length; i++){
            int minH = Math.min(leftSeeHighest[i],rightSeeHighest[i]);
            if(minH>height[i]){
                total += minH-height[i];
            }
        }
        return total;

    }
}

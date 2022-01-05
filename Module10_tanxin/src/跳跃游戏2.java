/**
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 思路：每次出发。看这次能走的步数中能走到最远的，作为下一步的落脚点，递归
 * 终止条件：这一步能走到终点
 */

public class 跳跃游戏2 {
    int result=0;
    public int jump(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        jumpThisStep(nums,0,1);
        return result;
    }

    private void jumpThisStep(int[] nums, int index, int times) {
        if(index+nums[index]>=nums.length-1){
            result=times;
            return;
        }
        int nextIndex=index+1;
        int max = index+1+nums[index+1];
        for(int i=index+2;i<=index+nums[index];i++){
            if(i+nums[i]>max){
                max=i+nums[i];
                nextIndex=i;
            }
        }
        jumpThisStep(nums,nextIndex,times+1);
    }

}

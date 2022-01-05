/**
 * 334. 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 思考：一开始想用最长递增子序列来做，动态规划效率为n^2这样效率肯定不高，而且计算明显冗余
 * 方法2：如果是递增的二元子序列，怎么做，维护一个最小的数字，从左到右如果有比最小的大的数字则找到！
 *       拓展至三元，维护最小和次小！ 最小：一直找最小的那个， 次小：比当前记录的最小大，且比当前记录的次小小的时候刷新！
 *       最小和次小初始化要比Integer.max大，用long把
 *       新进一个数字，1.比次小大，return ture 2在次小和最小中间，刷新次小 3小于最小 刷新最小
 */

public class 递增的三元子序列334 {
    public boolean increasingTriplet(int[] nums) {
    long mini1= Long.MAX_VALUE;
    long mini2 = Long.MAX_VALUE;
    for(int i=0;i<nums.length;i++){
        if(nums[i]>mini2) {
            return true;
        }else if(nums[i]<mini2&&nums[i]>mini1){
            mini2=nums[i];
        }else if(nums[i]<mini1){
            mini1=nums[i];
        }
    }
    return false;
    }
}

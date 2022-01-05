/**
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 思路:nums[-1] [len] = -无穷 ，意味着一定有峰值
 * 要求logn一定要二分法
 * 怎么分呢？思考一下取一个中间值i
 * 如果nums[i-1]<nums[i]>nums[i+1]  bingo!
 * 如果nums[i-1]>nums[i]>nums[i+1]  左边肯定有峰值
 * 如果nums[i-1]<nums[i]<nums[i+1]  右边肯定有峰值
 * 如果nums[i-1]>nums[i]<nums[i+1]  右边肯定有峰值
 *
 *搞起！
 */

public class 寻找峰值162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        return find(nums, left, right);
    }

    private int find(int[] nums, int left, int right) {
        int mid =(left+right)/2;
        long midNum = getNumFromNums(nums, mid);
        long midNum_1 = getNumFromNums(nums, mid-1); //mid-1
        long midNum_2 = getNumFromNums(nums, mid+1); //mid+1
        if(midNum>midNum_1&&midNum>midNum_2){
            return mid;
        }else if(midNum<midNum_2){ //往右边找
            return find(nums,mid+1,right);
        }else {
            return find(nums,left,mid-1);
        }

    }

    private long getNumFromNums(int[] nums, int i) {
        if(i>=0&&i<nums.length){
            return nums[i];
        }else {
            return Long.MIN_VALUE;
        }
    }
}

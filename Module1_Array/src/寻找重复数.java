/**
 * moon
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 */
//思路 求和减去1+2+..+n
public class 寻找重复数 {
    public int findDuplicate(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        for(int i=1;i<nums.length;i++){
            sum-=i;
        }
        return sum;
    }
}

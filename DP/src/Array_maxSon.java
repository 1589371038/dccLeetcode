//53. 最大子序和
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
public class Array_maxSon {
    public int maxSubArray(int[] nums) {
if(nums==null||nums.length==0){
    return 0;
}
int [] dp=new int[nums.length];
dp[0]=nums[0];
int max=dp[0];
for(int i=0; i<nums.length;i++){
    dp[i]=dp[i-1]>0?(dp[i-1]+nums[i]):nums[i];
    max=Math.max(dp[i],max);
}
return max;
    }
    //思路 dp[i]表示以i为结尾的位置的最大子数组和， 那么dp[i+1] = dp[i]>0?dp[i] + nums[i] :nums[i]
    public int maxSubArray1(int[] nums) {
        if(nums == null || nums.length<1){
            return 0;
        }
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i<nums.length; i++){
            dp[i] = dp[i-1]>0?dp[i-1] + nums[i] :nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
//思考：dp完成  dp[i]代表以i为结尾的最长递增子序列的长度
    //那么dp[i] = max(dp[j])+1  其中nums[j]<nums[i]  /每次都得往前扫描，复杂度为n^2，不是最优解
public class 最长递增子序列 {
    public static int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array =new int[]{10,9,2,5,3,7,101,18};
        int i = lengthOfLIS(array);
    }
}

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 */

public class 目标和 {
    //zheng - fu =target
    //zheng = fu + target
    //zheng +zheng = zheng + fu +targeT
    //ZHENG =（total+target）/2
    public static int findTargetSumWays(int[] nums, int target) {
        if(nums==null||nums.length<1){
            return 0;
        }
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        int newTarget = target+total; //目标转化为取+的数总和达到(target+total)/2
        if(newTarget<0||newTarget%2!=0){
            return 0;
        }
        newTarget = newTarget/2;
        //动态规划 dpij表示0-i下标为i-1的数字能组成j的组合数
        int[][]dp=new int[nums.length+1][newTarget+1];
        dp[0][0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                //  dp[i][j]=dp[i-1][j]+j>=nums[i-1]?dp[i-1][j-nums[i-1]]:0;
                dp[i][j]=dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j]=dp[i][j]+dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][newTarget];
    }

    public static void main(String[] args) {
        findTargetSumWays(new int[]{1,1,1,1,1},3);
    }
}

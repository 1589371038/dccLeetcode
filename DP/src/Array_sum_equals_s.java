//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

//返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/target-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//典型的01背包问题，状态转移方程为dp[i][j]=dp[i-1][j-nums[i]]+dp[i-1][j+nums[j]]
//坑1  s有正有负
//坑2  dp[0][j]=0/1 当nums[i]>0  dp[0][0]=2 当nums[i]=0;
//先用容量大的做
public class Array_sum_equals_s {
    public int findTargetSumWays(int[] nums, int S) {
//        排除边界条件
        if(nums==null||nums.length==0||nums.length>20||Math.abs(S)>1000){
            return 0;
        }
int [][]dp=new int[nums.length][2001];
for(int j=0;j<2001;j++){
    if(nums[0]==j-1000||j-1000==-nums[0]){
        dp[0][j]++;
    }
    else{dp[0][j]=0;}
}
if(nums[0]==0){
    dp[0][1000]++;
}
//此处考虑0-2000边界越界的问题，已知越界的dp肯定为0，但是继续扩容有不合适，因此要加上判断
for(int i=1;i<nums.length;i++){
    for(int j=0;j<2001;j++){
//        不越界就用dp，越界就用0
        int n1=((j-nums[i])>=0&&(j-nums[i])<=2000)?dp[i-1][j-nums[i]]:0;
        int n2=((j+nums[i])>=0&&(j+nums[i])<=2000)?dp[i-1][j+nums[i]]:0;
        dp[i][j]=n1+n2;

    }
}
return dp[nums.length-1][S+1000];
    }
}

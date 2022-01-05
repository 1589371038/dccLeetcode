//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//        注意:
//        每个数组中的元素不会超过 100
//        数组的大小不会超过 200
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Sum_equals_Val {
//    也就是能不能抽出sum/2
//    首先sum得是偶数！
//    其次，从小的开始dp嘛  dp[i][j]第i个下标开始，能否组成和为j
//    边界dp[i][0]=false; dp[0][j]=f/t取决于nums[0]是否等于j
//    转移方程：dp[i][j]=dp[i-1][j] or dp[i-1][j-nums[i]] (j>nums[i])
//                         = true (j=nums[i])
//                         =dp[i-1][j] (j<nums[i]))
//    为了减少内存，只用一个数组
    public boolean canPartition(int[] nums) {
if(nums==null||nums.length<2){
    return false;
}
int sum=0;
for(int i=0;i<nums.length;i++){
    sum+=nums[i];
}
if(sum%2!=0){
    return  false;
}
int target=sum/2;
boolean [] dp=new boolean[target+1];
//初始化
        for(int j=0;j<target+1;j++){
            dp[j]=nums[0]==j;
        }
//        dp过程
        for(int i=1;i<nums.length;i++){
            for(int j=target;j>=0;j--){
                if(nums[i]==j){
                    dp[j]=true;
                }
                else if(nums[i]<j){
                    dp[j]=dp[j-nums[i]]||dp[j];
                }
                else{
                    dp[j]=dp[j];
                }
            }
        }
        return dp[target];
    }
}

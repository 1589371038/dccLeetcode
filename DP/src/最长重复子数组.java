/**
 *718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 */
//思考：和最长公共子串一个道理 dp[i][j]代表nums1以i为结尾的子数组(必须包含)和 nums2以j为结尾的子数组的匹配长度
    //dp[i][j]== nums[i]==nums[j]? dp[i-1][j-1]+1 :0
public class 最长重复子数组 {
    public int findLength(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null||nums1.length<1||nums2.length<1){
            return 0;
        }
        int[][] dp =new int[nums1.length][nums2.length];
        int max=0;
        //初始化
        for(int j=0;j<nums2.length;j++){
            dp[0][j]=nums1[0]==nums2[j]?1:0;
            max=Math.max(max,dp[0][j]);
        }
        for(int i=0;i<nums1.length;i++){
            dp[i][0]=nums1[i]==nums2[0]?1:0;
            max=Math.max(max,dp[i][0]);
        }
        //dp
        for(int i=1;i<nums1.length;i++){
            for(int j=1;j<=nums2.length;j++){
                if(nums1[i]!=nums2[j]){
                    dp[i][j]=0;
                }else {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}

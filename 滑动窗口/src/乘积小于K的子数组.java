/**
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ZVAVXX
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：最笨的方法肯定是n^2
 * 但是我们是很聪明的小朋友
 *
 * 双指针：
 * 性质：如果lr之间乘积小于K，那么 R为结尾 的数组有R-L+1个
 * 计算每一个R结尾的，符合条件的数组数量！
 * 循环条件：R<n
 * 如果sum<k, R每次往右移动就刷新结果，result + = R-L+1
 * 如果sum>=k 右移L，直到sum<k
 * 在只R右移的时候计算结果
 * 如果L缩的时候=R了，说明这个数字大于target,LR都右移
 */

public class 乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    int l = 0;
    int r = 0;
    int sum = 1;
    int res = 0;
    while (r < nums.length){
            sum*=nums[r];
            while (sum>=k && l<=r){
                sum/=nums[l];
                l++;
            }
            if(sum<k){
                res+=r-l+1;
            }
            r++;
    }
    return  res;
    }
}

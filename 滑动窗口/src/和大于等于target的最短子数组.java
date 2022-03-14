/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2VG8Kg
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 思路：假如固定左边界R， 那么找到最小的R使得 和 》=target 就可以刷新结果， 效率n^2
 * 优化：用前缀和+二分查找  优化到nlogn
 *
 * 思路2：双指针
 *  右指针往右，直到 sum>=target 不计结果
 *  左指针开始缩,直到sum<target 在这个过程中不断刷新结果
 *
 *  循环终止条件：r< n
 */

public class 和大于等于target的最短子数组 {
    public  static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < nums.length){
            // r前进
            while (sum< target && r < nums.length){
                sum += nums[r];
                r++;
            }
            // l缩
            while (sum>=target){
                minLen = Math.min(minLen, r-l);
                sum -= nums[l];
                l++;
            }
        }

        if(minLen == Integer.MAX_VALUE){
            return 0;
        }else return minLen;
    }

    public static void main(String[] args) {
       int res =  minSubArrayLen(7,new int[]{2,3,1,2,4,3});
        System.out.println(res);
    }

}

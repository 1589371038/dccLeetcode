import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * 思路：暴力的复杂度是n^4不可取
 * 这道题不用去重，可以hash空间换时间
 * nums1+nums2的结果存储在hash中  nums3+nums4遍历，从hash中拿数据
 * 注意获取所有的个数，所以hash用map value是次数
 */

public class 四数相加Ⅱ {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map.put(nums1[i]+nums2[j],map.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum34 = nums3[i]+nums4[j];
                count+=map.getOrDefault(-sum34,0);
            }}

        return count;
    }
}
